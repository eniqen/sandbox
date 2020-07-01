package com.github.eniqen.algo.sliding_window

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
object LongestSubstringWithKDistinctCharacters extends App {
  val s = "cbbebi"
  val k = 3


  def findLength(k: Int, s: String): Int = {
    var maxLength = 0
    var start = 0
    var freq = Map.newBuilder[Char, Int].result()

    for(end <- 0 until s.length) {
      val cur = s(end)
      freq = freq.updated(cur, freq.getOrElse(cur, 0) + 1)
      while(freq.size > k) {
        val toDelete = s.charAt(start)
        freq = freq.updated(toDelete, freq(toDelete) - 1)
        if(freq(toDelete) == 0) freq = freq - toDelete
        start += 1
      }
      maxLength = math.max(maxLength, end - start + 1)
    }
    maxLength
  }

  println(findLength(k, s))
}
