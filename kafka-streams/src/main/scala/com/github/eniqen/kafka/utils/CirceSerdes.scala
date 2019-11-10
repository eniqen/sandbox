package com.github.eniqen.kafka.utils

import java.nio.charset.StandardCharsets

import io.circe.{ Decoder, Encoder }
import io.circe.parser._
import org.apache.kafka.common.errors.SerializationException
import org.apache.kafka.common.serialization.{ Deserializer, Serde, Serdes, Serializer }

/**
 * @author Mikhail Nemenko { @literal <nemenkoma@gmail.com>}
 */
object CirceSerdes {

  implicit def circeSerializer[T: Encoder]: Serializer[T] =
    (_: String, data: T) => Encoder[T].apply(data).noSpaces.getBytes(StandardCharsets.UTF_8)

  implicit def circeDeserializer[T: Decoder]: Deserializer[T] =
    new Deserializer[T] {
      override def deserialize(topic: String, data: Array[Byte]): T =
        Option(data).fold(null.asInstanceOf[T]) {
          decode[T](new String(data, StandardCharsets.UTF_8))
            .fold(err => throw new SerializationException(err), identity)
        }
    }

  implicit def circeSerde[T: Encoder: Decoder]: Serde[T] =
    Serdes.serdeFrom(circeSerializer, circeDeserializer)
}
