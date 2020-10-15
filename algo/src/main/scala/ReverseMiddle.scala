import scala.annotation.tailrec

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
object ReverseMiddle  extends  App {
  def solution(list: List[Int], p: Int, q: Int): List[Int] = {
    @tailrec
    def go(start: List[Int], left: List[Int], middle: List[Int], last: List[Int], p: Int, q: Int): List[Int] =
      start match {
      case Nil => left ::: middle ::: last
      case h::t if p > 1 => go(t, h :: left, middle, last, p - 1, q)
      case h::t if q > 1 => go(t, left, h :: middle, last, p, q - 1)
      case shrink => go(Nil, left.reverse, middle, shrink, p, q)
    }

    go(list, List.empty[Int], List.empty[Int], List.empty[Int], p, q)
  }

  println(solution(List(1,2,3,4,5), 2, 4).mkString(","))
}
