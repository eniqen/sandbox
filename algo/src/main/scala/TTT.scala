import java.util

import scala.collection.mutable

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
object TTT extends App {


  def solve(arr: Array[Int]): Int = {
    val timeLimit: Int = 1
    val reqLimit: Int = 3

    val timeLimit2: Int = 10
    val reqLimit2:Int = 20
    val rateLimit: util.Queue[Int] = new util.LinkedList[Int]()
    val rateLimit2: util.Queue[Int] = new util.LinkedList[Int]()

    count(rateLimit, rateLimit2, arr, timeLimit, timeLimit2, reqLimit, reqLimit2)
  }

  def count(limiter: util.Queue[Int], limiter2: util.Queue[Int], arr: Array[Int], tl: Int, tl2: Int, rl: Int, rl2: Int): Int = {

    var result = 0
    arr.foreach{
      cur =>
      limiter.offer(cur)
      limiter2.offer(cur)

      while(!limiter.isEmpty && limiter.size > rl) {
        val x = limiter.poll()
        if(cur - x >= tl) {
          result += 1
        }
      }

        while(!limiter2.isEmpty && limiter2.size > rl2) {
          val x = limiter2.poll()
          if(cur - x >= tl2) {
            result += 1
          }
        }
    }

    result
  }

  val data = Array(1,1,1,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,11,11,11,11)
  println(solve(data))
}
