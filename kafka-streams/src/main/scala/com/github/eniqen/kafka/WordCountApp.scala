package com.github.eniqen.kafka

import java.util.Properties

import org.apache.kafka.clients.consumer.ConsumerConfig.AUTO_OFFSET_RESET_CONFIG
import org.apache.kafka.streams.KafkaStreams
import org.apache.kafka.streams.StreamsConfig.{APPLICATION_ID_CONFIG, BOOTSTRAP_SERVERS_CONFIG}
import org.apache.kafka.streams.kstream.Printed
import org.apache.kafka.streams.scala.StreamsBuilder
import org.apache.kafka.streams.scala.kstream.KStream
import scala.concurrent.duration._
import org.apache.kafka.streams.scala.ImplicitConversions._
import org.apache.kafka.streams.scala.Serdes._

/**
 * @author Mikhail Nemenko { @literal <nemenkoma@gmail.com>}
 */
class WordCountApp {
  def main(args: Array[String]): Unit = {
    val properties = new Properties()
    properties.put(APPLICATION_ID_CONFIG, Config.AppId)
    properties.put(BOOTSTRAP_SERVERS_CONFIG, Config.BootstrapServers)
    properties.put(AUTO_OFFSET_RESET_CONFIG, Config.OffsEarliest)

    val builder = new StreamsBuilder
    val wordStream: KStream[String, String] =
      builder.stream[String, String](Config.Topic.WordCountIn.name)

    wordStream
      .mapValues(_.toLowerCase)
      .flatMapValues(_.split("\\W+"))
      .selectKey { case (_, v) => v }
      .groupByKey
      .count()
      .toStream
      .print(Printed.toSysOut())
//      .to(Config.TopicOut)

    val wordsStream = new KafkaStreams(builder.build(), properties)
    wordsStream.start()

    sys.ShutdownHookThread {
      import java.time.Duration
      wordsStream.close(Duration.ofSeconds(10.seconds.toMillis))
    }
  }
}


/*
zookeeper-server-start.sh -daemon ~/Applications/kafka/config/zookeeper.properties
kafka-server-start.sh -daemon ~/Applications/kafka/config/server.properties
kafka-topics.sh --create --topic "word-count-input" --replication-factor 1 --partitions 2 --bootstrap-server localhost:9092
kafka-topics.sh --create --topic "word-count-output" --replication-factor 1 --partitions 2 --bootstrap-server localhost:9092
kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic word-count-output --from-beginning --property print.key=true --property print.value=true --property key.deserializer=org.apache.kafka.common.serialization.StringDeserializer --property value.deserializer=org.apache.kafka.common.serialization.LongDeserializer
kafka-console-producer.sh --broker-list localhost:9092 --topic "word-count-input"
 */
