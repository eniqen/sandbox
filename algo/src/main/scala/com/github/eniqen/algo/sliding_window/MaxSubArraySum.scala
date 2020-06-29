package com.github.eniqen.algo.sliding_window

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
object MaxSubArraySum extends App {
  val data = Array(2, 1, 5, 1, 3, 2)
  val k = 3

  def findMaxSumSubArray(k: Int, data: Array[Int]): Int = {
    var start = 0
    var max = 0
    var sum = 0

    for(end <- data.indices) {
      sum += data(end)
      if (end >= k - 1) {
        max = math.max(max, sum)
        sum -= data(start)
        start += 1
      }
    }
    max
  }

  println(findMaxSumSubArray(k, data))
}
