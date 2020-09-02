import scala.annotation.tailrec

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
object FairSum extends App {
  val left = Array(1, 4, 2, -2, 5) //10
  val right = Array(7, -2, -2, 2, 5) // 10

  def find(l: Array[Int], r: Array[Int]): Seq[Int] = {
    @tailrec
    def loop(
      result: Seq[Int],
      leftStartWindowSum: Long,
      leftEndWindowSum: Long,
      rightStartWindowSum: Long,
      rightEndWindowSum: Long,
      fairIndex: Int
    ): Seq[Int] = fairIndex match {
      case _ if fairIndex >= l.length => result
      case _                          =>

        val newLeftStartSum = leftStartWindowSum + l(fairIndex - 1)
        val newLeftEndSum   = leftEndWindowSum - l(fairIndex - 1)

        val newRightStartSum = rightStartWindowSum + r(fairIndex - 1)
        val newRightEndSum    = rightEndWindowSum -  r(fairIndex - 1)

        val newResult = if(newLeftStartSum == newLeftEndSum && newRightStartSum == newRightEndSum && newLeftStartSum == newRightStartSum) {
          result :+ fairIndex
        } else result

        loop(newResult, newLeftStartSum, newLeftEndSum, newRightStartSum, newRightEndSum, fairIndex + 1)
    }

    loop(
      Seq.empty[Int],
      leftStartWindowSum = 0L,
      leftEndWindowSum = l.sum,
      rightStartWindowSum = 0L,
      rightEndWindowSum = r.sum,
      fairIndex = 1
    )
  }

  println(find(left, right).mkString(", "))
}
