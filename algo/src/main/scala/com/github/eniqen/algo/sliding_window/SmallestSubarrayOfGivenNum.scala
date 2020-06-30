package com.github.eniqen.algo.sliding_window

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
object SmallestSubarrayOfGivenNum extends App {

  def findMinSubArray(s: Int, data: Array[Int]): Int = {
    var minLength = Int.MaxValue
    var start = 0
    var sum = 0
    for(end <- data.indices) {
      sum += data(end)
      while(sum >= s) {
        minLength = math.min(minLength, end - start + 1)
        sum -= data(start)
        start += 1
      }
    }

    if(minLength == Int.MaxValue) 0 else minLength
  }

  val data = Array(2, 1, 5, 2, 3, 2)
  val sum = 7
  println(findMinSubArray(sum, data))
}
