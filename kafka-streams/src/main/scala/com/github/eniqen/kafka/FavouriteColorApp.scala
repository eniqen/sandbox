package com.github.eniqen.kafka

import java.util.Properties

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.streams.{KafkaStreams, KeyValue, StreamsBuilder}
import org.apache.kafka.streams.StreamsConfig._
import org.apache.kafka.streams.kstream.{KStream, KTable, Printed}
import org.apache.kafka.streams.scala.ImplicitConversions._
import org.apache.kafka.streams.scala.Serdes._
import scala.concurrent.duration._

/**
 * @author Mikhail Nemenko { @literal <nemenkoma@gmail.com>}
 */
class FavouriteColorApp {
  def main(args: Array[String]): Unit = {

    val SEPARATOR = ","
    val supportedColors = Set("red", "green", "blue")

    val props = new Properties()
    props.put(BOOTSTRAP_SERVERS_CONFIG, Config.BootstrapServers)
    props.put(APPLICATION_ID_CONFIG, Config.AppId)
    props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, Config.OffsEarliest)
    props.put(CACHE_MAX_BYTES_BUFFERING_CONFIG, "0")

    val builder = new StreamsBuilder()

    val usersAndColorsStream: KStream[String, String] =
      builder.stream[String, String](Config.Topic.FavouriteColorIn.name)

    usersAndColorsStream
      .filter((_, v) => v.contains(SEPARATOR))
      .selectKey((_, v) => v.split(SEPARATOR).head.toLowerCase.trim)
      .mapValues(_.split(SEPARATOR).tail.head.toLowerCase.trim)
      .filter((_, v) => supportedColors(v))

    usersAndColorsStream.to(Config.Topic.FavouriteColorUsersColors.name)

    val favouriteColorsTable: KTable[String, String] =
      builder.table[String, String](Config.Topic.FavouriteColorUsersColors.name)
    favouriteColorsTable
      .groupBy((_, color) => new KeyValue(color, color))
      .count()

    favouriteColorsTable.toStream
      .print(Printed.toSysOut())
    //      .to(Config.Topic.FavouriteColorOut.name)

    val kafkaStream = new KafkaStreams(builder.build, props)
    kafkaStream.start()

    sys.addShutdownHook {
      import java.time.Duration
      kafkaStream.close(Duration.ofSeconds(10.seconds.toMillis))
    }
  }
}

/*
zookeeper-server-start.sh -daemon ~/Applications/kafka/config/zookeeper.properties
kafka-server-start.sh -daemon ~/Applications/kafka/config/server.properties
kafka-topics.sh --create --topic "favourite-color-in" --replication-factor 1 --partitions 2 --bootstrap-server localhost:9092
kafka-topics.sh --create --topic "favourite-color-out" --replication-factor 1 --partitions 1 --bootstrap-server localhost:9092 --config cleanup.policy=compact
kafka-topics.sh --create --topic ""user-keys-and-color"" --replication-factor 1 --partitions 1 --bootstrap-server localhost:9092 --config cleanup.policy=compact
kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic word-count-output --from-beginning --property print.key=true --property print.value=true --property key.deserializer=org.apache.kafka.common.serialization.StringDeserializer --property value.deserializer=org.apache.kafka.common.serialization.LongDeserializer
kafka-console-producer.sh --broker-list localhost:9092 --topic "word-count-input"
*/
