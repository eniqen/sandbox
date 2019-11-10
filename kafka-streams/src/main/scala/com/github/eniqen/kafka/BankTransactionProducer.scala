package com.github.eniqen.kafka

import java.time.Instant
import java.util.Properties
import java.util.concurrent.TimeUnit

import org.apache.kafka.common.serialization.StringSerializer
import org.apache.kafka.clients.producer.ProducerConfig._
import org.apache.kafka.clients.producer._
import org.apache.kafka.streams.scala.ImplicitConversions._
import org.apache.kafka.streams.scala.Serdes._

import scala.util.Random

/**
 * @author Mikhail Nemenko { @literal <nemenkoma@gmail.com>}
 */
object BankTransactionProducer extends App {

  final case class Name(name: String) extends AnyVal

  final case class Transaction(name: Name,
                               amount: Int = Random.nextInt(100),
                               timestamp: Instant = Instant.now())

  val users = List("Eugene", "Boris", "Vasya")

  def getInfiniteStreamFrom[A](seq: List[A]): Stream[A] = Stream.continually(seq.toStream).flatten

  def throttle[A](delayMs: Long): Stream[A] => Stream[A] =
    stream => (stream zip Stream.continually(Thread.sleep(delayMs))).map(_._1)

  def runWithDelay(delayMs: Long): Stream[Transaction] =
    throttle(delayMs)(getInfiniteStreamFrom(users)).map(name => Transaction(Name(name)))

  def json(transaction: Transaction): String =
    s"""
         | {
         |   "name": "${transaction.name.name}"
         |   "amount": ${transaction.amount}
         |   "time": "${transaction.timestamp.toString}"
         | }
      """.stripMargin

  val props = new Properties()
  props.put(BOOTSTRAP_SERVERS_CONFIG, Config.BootstrapServers)
  props.put(ENABLE_IDEMPOTENCE_CONFIG, "true")
  props.put(ACKS_CONFIG, "all")
  props.put(RETRIES_CONFIG, "3")
  props.put(LINGER_MS_CONFIG, "1")
  props.put(KEY_SERIALIZER_CLASS_CONFIG, classOf[StringSerializer].getName)
  props.put(VALUE_SERIALIZER_CLASS_CONFIG, classOf[StringSerializer].getName)

  val producer                                        = new KafkaProducer[String, String](props)
  def record[K, V](key: K, v: V)(topic: Config.Topic) = new ProducerRecord[K, V](topic.name, key, v)

  try {
    runWithDelay(TimeUnit.SECONDS.toMillis(3)).foreach { transaction =>
      val rec: Config.Topic => ProducerRecord[String, String] =
        record(transaction.name.name, json(transaction))

      producer.send(
        rec(Config.Topic.BankBalanceIn),
        (metadata: RecordMetadata, exception: Exception) =>
          metadata -> exception match {
            case (meta, null) => println("SUCCESS " + meta)
            case (null, err)  => println("FAILURE " + err.getMessage)
            case _            => println("Unknown")
        }
      )
    }
  } catch {
    case err: Throwable =>
      println(s"Producer was failed with error: ${err.getMessage}")
      producer.close()
  }
}
