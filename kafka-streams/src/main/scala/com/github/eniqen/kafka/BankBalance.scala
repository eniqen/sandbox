package com.github.eniqen.kafka

import java.util.Properties

import org.apache.kafka.clients.consumer.ConsumerConfig.AUTO_OFFSET_RESET_CONFIG
import org.apache.kafka.streams.{KafkaStreams, StreamsBuilder}
import org.apache.kafka.streams.StreamsConfig._
import org.apache.kafka.streams.scala.Serdes
import org.apache.kafka.streams.scala.kstream.Consumed

import scala.concurrent.duration._
import io.circe.parser._

/**
 * @author Mikhail Nemenko { @literal <nemenkoma@gmail.com>}
 */
class BankBalance {
  def main(args: Array[String]): Unit = {
    import com.github.eniqen.kafka.utils.CirceSerdes._

    val props = new Properties()
    props.put(APPLICATION_ID_CONFIG, Config.BankAppId)
    props.put(BOOTSTRAP_SERVERS_CONFIG, Config.BootstrapServers)
    props.put(PROCESSING_GUARANTEE_CONFIG, EXACTLY_ONCE)
    props.put(AUTO_OFFSET_RESET_CONFIG, Config.OffsEarliest)
    props.put(CACHE_MAX_BYTES_BUFFERING_CONFIG, "0")

    val builder = new StreamsBuilder

    val bankTransactionStream = builder.stream(Config.Topic.BankBalanceIn.name, Consumed.`with`(Serdes.String, circeSerde))
//    bankTransactionStream.groupByKey().aggregate(
//
//    )

    val stream = new KafkaStreams(builder.build(), props)
    stream.start()

    sys.addShutdownHook {
      import java.time.Duration
      stream.close(Duration.ofSeconds(10.seconds.toMillis))
    }
  }
}
