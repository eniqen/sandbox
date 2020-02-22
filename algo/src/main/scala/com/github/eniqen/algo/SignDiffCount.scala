package com.github.eniqen.algo
import scala.annotation.tailrec

/**
 * @author Mikhail Nemenko
 */
object SignDiffCount {

  def getSignDiffCount(l: List[Int]): Int = {
    def diffSign(f: Int, s: Int): Boolean = f >= 0 && s < 0

    @tailrec
    def go(list: List[Int], acc: Int): Int = list match {
      case x :: xs :: xss =>
        val count = if (diffSign(x, xs) || diffSign(xs, x)) 1 else 0
        go(xs :: xss, acc + count)
      case _              => acc
    }
    go(l, 0)
  }

  val list = List(0, -1, 2, 4, 5, -9, 4)

  println(getSignDiffCount(list))
}
