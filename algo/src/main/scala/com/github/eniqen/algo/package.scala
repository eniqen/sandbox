package com.github.eniqen
import scala.collection.mutable.Buffer
import scala.util.Random

/**
 * @author Mikhail Nemenko
 */
package object algo {

  def randomList: Buffer[Int] = (0 until 10)./:((Buffer.newBuilder[Int], Random)) {
    case ((acc, r), _) => (acc += r.nextInt(100)) -> r
  }._1.result()

}
