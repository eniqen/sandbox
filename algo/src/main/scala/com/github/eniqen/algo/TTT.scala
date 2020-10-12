//package com.github.eniqen.algo
//import scala.annotation.tailrec
//
///**
// * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
// */
//object TTT extends App {
//  println(solution(3, 2, Array(2,1,1,0,1)))
//  def solution(u: Int, l: Int, c: Array[Int]): String = {
//    val result = Array.fill(c.length)(0) -> Array.fill(c.length)(0)
//
//    def convert(upper: Array[Int], lower: Array[Int]): String =
//      s"${upper.mkString},${lower.mkString}"
//
//    @tailrec
//    def go(arr: Array[Int], upper: Int, lower: Int, cur: Int)(result: (Array[Int], Array[Int])): String = {
//      if(lower < 0 || upper < 0) "IMPOSSIBLE"
//      else if(cur > arr.length && lower + upper == 0) convert(result._1, result._2)
//      else {
//        val current = arr(cur)
//        if(current == 2) {
//          result._1(cur) = 1
//          result._2(cur) = 1
//          go(arr, upper - 1, lower - 1, cur + 1)(result)
//        } else if(current == 1) {
//          if(up) {
//            go(arr, upper - 1, lower, cur + 1)
//          } else go(arr, upper, lower - 1, cur + 1)(result)
//        } else {
//          go(arr, upper, lower, cur + 1)(result)
//        }
//      }
//    }
//
//    go(c, u, l, 0)(result)
//  }
//}
