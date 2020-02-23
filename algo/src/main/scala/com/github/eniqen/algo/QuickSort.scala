package com.github.eniqen.algo
import scala.reflect.ClassTag

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
object QuickSort extends App {
  sealed trait Pivot
  case object First                       extends Pivot
  case object Middle                      extends Pivot
  case object Last                        extends Pivot
  case class Random(r: scala.util.Random) extends Pivot

  val array = randomList.toArray
  val array2 = randomList.toArray

  println(sort(array).mkString(","))

  println(sort2(First, 0, array2.length - 1, array2).mkString(","))


  def sort[T: Ordering: ClassTag](array: Array[T]): Array[T] = {
    def pivot[T](array: Array[T])(implicit O: Ordering[T]): (Array[T], T, Array[T]) = {
      val startEll        = array.head
      val (less, greater) = array.partition(O.compare(_, startEll) < 0)
      (less, startEll, greater.tail)
    }

    if (array.length < 2) array
    else {
      val (l, p, g) = pivot(array)
      sort(l) ++ Array(p) ++ sort(g)
    }
  }

  def sort2[T: Ordering](pivot: Pivot, low: Int, high: Int, array: Array[T]): Array[T] = {
    def partition(pivotIndex: Int, low: Int, high: Int): Int = {
      val pivot = array(pivotIndex)
      var start = low
      var end = high
      while(start <= end) {
        while(Ordering[T].compare(array(start), pivot) < 0) start += 1
        while(Ordering[T].compare(array(end), pivot) > 0) end -= 1

        if(start <= end) {
          swap(start, end)(array)
          start += 1
          end -= 1
        }
      }
      start
    }

    def swap(from: Int, to: Int): Unit = {
      val temp = array(from)
      array(from) = array(to)
      array(to) = temp
    }

    def choosePivot(array: Array[T], low: Int, high: Int): Pivot => Int = {
      case First     => low
      case Middle    => (low + high) / 2
      case Last      => high
      case Random(r) => high + r.nextInt(high - low) + 1
    }

    if (low >= high) array
    else {
      val pivotIndex = choosePivot(array, low, high)(pivot)
      val index = partition(pivotIndex, low, high)

      sort2(pivot, low, index - 1, array)
      sort2(pivot, index, high, array)
    }
  }
}
