/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
object ClosestSumFinder extends App {
    def solution(n: Int): Int = {
      def go(n: Int, expected: Int)(fn: Int => Int): Int = fn(n) match {
        case r if r == expected      => n
        case r                       => go(n + 1, expected)(fn)
      }
      def fn: Int => Int = n => getSum(n)
      go(n + 1, fn(n))(fn)
    }

    private def getSum(n: Int): Int = {
      def loop(n: Int, result: Int): Int =
        if(n > 0) loop(n / 10, result + (n % 10)) else result
      loop(n, 0)
    }

  println(solution(23))
}
