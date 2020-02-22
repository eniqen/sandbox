package com.github.eniqen.algo
import scala.annotation.tailrec
import scala.collection.mutable.{Buffer, Builder}

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
object SelectionSort extends App {

  final case class Index(v: Int) extends AnyVal

  def sort[A](list: Buffer[A])(implicit O: Ordering[A]): Buffer[A] = {

    def minIndex(b: Buffer[A]): Index = {
      var minIndex = 0
      var minValue = b(minIndex)

      (minIndex until b.size).foreach {
        index =>
        val ell = b(index)
        if(O.compare(ell, minValue) < 0) {
          minIndex = index
          minValue = ell
        }
      }
      Index(minIndex)
    }

    @tailrec
    def go(list: Buffer[A], acc: Builder[A,Buffer[A]]): Builder[A, Buffer[A]] = {
      if (list.isEmpty) acc else {
        val index = minIndex(list)
        val minValue = list.remove(index.v)
        go(list, acc += minValue)
      }
    }
    go(list, Buffer.newBuilder[A]).result()
  }

  val list = randomList
  println(s"before ${list.mkString(",")}")
  println(s"sorted ${sort(list)}")
}
