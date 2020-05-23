package com.github.eniqen.algo
import scala.annotation.tailrec

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
object Google extends App {

  println(repeatN("abc4xd"))
  println(repeatN("4x"))
  println(repeatN("4"))
  println(repeatN("a"))
  println(repeatN("a4"))
  println(repeatN("10a"))
  println(repeatN("10xb"))
  println(repeatN("a2x3xdb"))

  def repeatN(raw: String): String = {
    @tailrec
    def go(raw: List[Char], digits: List[Char], acc: String): String =  (raw, digits) match {
      case (Nil, Nil) => acc
      case (Nil, d) => acc + new String(d.toArray)
      case ('x'::ch::t, d@ List(_*)) if ch.isDigit => go(t, ch :: Nil, acc + new String(d.reverse.toArray) + 'x')
      case ('x'::ch::t, d@ List(_*)) => go(t, List.empty[Char], acc + repeat(d.reverse.toArray, ch))
      case (h::t, d) if h.isDigit => go(t, h::d, acc)
      case (h::t, d@ List(_*)) => go(t, List.empty[Char], acc + new String(d.reverse.toArray) + h)
    }

    go(raw.toCharArray.toList, List.empty[Char],"")
  }

    def repeat(digit: Array[Char], ch: Char): String =
      List.fill(new String(digit).toInt)(ch).foldRight("")(_ + _)

}
