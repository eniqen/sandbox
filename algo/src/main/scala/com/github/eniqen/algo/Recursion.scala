package com.github.eniqen.algo
import scala.annotation.tailrec

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
object Recursion  extends App {

  @tailrec
  def go[A, B](list: List[A], acc: B)(fn: (B, A) => B): B = list match {
    case Nil => acc
    case x::xs => go(xs, fn(acc, x))(fn)
  }

  def sum(list: List[Int]): Int = go(list, 0)(_ + _)
  def count(list: List[Int]): Int = go(list, 0) {case (l, _) => l + 1 }
  def max(list: List[Int]): Int = go(list, 0)(Math.max)

  val list = randomList.toList

  println(s"Raw $list")
  println(s"Sum ${sum(list)}")
  println(s"Count ${count(list)}")
  println(s"Max ${max(list)}")

}
