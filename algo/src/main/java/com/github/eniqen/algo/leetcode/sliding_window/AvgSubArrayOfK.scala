package com.github.eniqen.algo.leetcode.sliding_window

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
object AvgSubArrayOfK extends App {

  val data = Array(1, 3, 2, 6, -1, 4, 1, 8, 2)
  val k = 5

  println(data.sliding(k, 1).map(_.sum.toDouble / k).mkString(", "))
  println(findAvg(data, k).mkString(", "))

  def findAvg(data: Array[Int], k: Int): Array[Double] = {
    val result = Array.fill(data.length - k + 1)(0d)
    for(index <- result.indices) yield {
      result(index) = avg(index, index + k)(data)
    }
    result
  }

  def avg(from: Int, to: Int): Array[Int] => Double = arr => {
    var sum = 0d
    for(i <- from until to) sum += arr(i)
    sum / (to - from)
  }
}
