
/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
object MatrixChecker extends App{

  def check(arr: Array[Int], upper: Int, lower: Int): String = {

    val lR = Array.fill(arr.length)(0)
    val rR = Array.fill(arr.length)(0)
    var u = upper
    var l = lower
    var impossible = false

    arr.zipWithIndex.foreach { case (v, i) =>
      if(v == 2 && l > 0 && u > 0) {
        lR(i) = 1
        rR(i) = 1
        l = l - 1
        u = u - 1
      } else if(v == 1 && u + l > 0) {
        if(u > l) {
          lR(i) = 1
          u = u - 1
        } else {
          rR(i) = 1
          l = l - 1
        }
      } else if(v == 0) {
        //just skip
      } else {
        impossible = true
      }
    }

    if(impossible || u + l > 0) "IMPOSSIBLE"
    else lR.mkString + "," + rR.mkString
  }


  def solution(u: Int, l: Int, c: Array[Int]): String = {

    var uc = u
    var lc = l
    var currentE = 0

    var allE = 0

    val isPossible = c.forall {
      case 2 =>
        if (uc > 0 && lc > 0) {
          uc -= 1
          lc -= 1
          true
        } else {
          if (uc == 0 && currentE > 0 && lc > 1) {
            currentE -= 1
            lc -= 2
            true
          } else {
            false
          }
        }

      case 1 =>
        allE += 1

        if (uc > 0) {
          currentE += 1
          uc -= 1
          true
        } else {
          if (uc == 0 && currentE > 0 && lc > 0) {
            currentE -= 1
            lc -= 1
            true
          } else {
            false
          }
        }
      case 0 =>
        true
    }

    if (isPossible && (uc == 0) && (lc ==0)) {
      val resMas = c.map {
        case 2 => ("1", "1")
        case 1 =>
          if (currentE > 0) {
            currentE -= 1
            ("0", "1")
          } else {
            ("1", "0")
          }

        case 0 => ("0", "0")
      }

      val (s1, s2) = resMas.unzip

      s"${s1.reduce(_ ++ _)},${s2.reduce(_ ++ _)}"
    } else {
      "IMPOSSIBLE"
    }

  }

  val u = 3
  val l = 2
  val c = Array(2, 1, 1 , 0, 1)
  val c2 = Array(0,0,1,1,2)
  val c3 = Array(2,0, 2, 0)
  val c4 = Array(2, 1, 2, 0, 1, 0, 1, 2, 0, 1)

//
//  println(check(c3, 2, 2))
//  println(solution(2, 2, c3))
//
//  println(check(c2, 2, 3))
//  println(solution(2, 3, c2))
//
//  println(check(c, 3, 2))
//  println(solution(3, 2, c))

  println(check(c4, 5, 5))
  println(solution(5, 5, c4))

}

//Example test:   (3, 2, [2, 1, 1, 0, 1])
//WRONG ANSWER (Wrong sum in the upper row (expected 3 got 2).)
//
//Example test:   (2, 3, [0, 0, 1, 1, 2])
//WRONG ANSWER (Expected "IMPOSSIBLE".)
//
//Example test:   (2, 2, [2, 0, 2, 0])
//OK
