package com.github.eniqen.algo
import scala.annotation.tailrec

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
object BinarySearch extends App {

  val array = Array(1, 3, 5, 7, 9, 10, 11, 17).sorted

  def search[T: Numeric: Ordering](array: Array[T])(v: T): Option[Int] = {
    @tailrec
    def loop(low: Int, high: Int): Option[Int] = array match {
      case arr if arr.isEmpty || low > high => None
      case arr =>
        val mid = (low + high) / 2
        val elem = arr(mid)
        Ordering[T].compare(elem, v) match {
          case v if v < 0 => loop(mid + 1, high)
          case v if v > 0 => loop(low, mid - 1)
          case v          => Some(mid)
        }
    }
    loop(0, array.length - 1)
  }

  println(search(array)(3))
  println(search(Array.empty[Int])(3))

}
