package com.github.eniqen.algo
import scala.annotation.tailrec

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
object Fib extends App {

  println(fib(696352))

  def fib(n: Int): BigInt = {
    @tailrec
    def helper(prev: BigInt, current: BigInt, index: Int): BigInt = {
      if (index == n) current + prev
      else helper(current, prev + current, index + 1)
    }

    if(n >= 2) helper(0, 2, 0)
    else n
  }
}
