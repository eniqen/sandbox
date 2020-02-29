package com.github.eniqen.algo
import scala.annotation.tailrec
import scala.collection.mutable

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
object Tree extends App {
  sealed trait Tree[+T] {
    def isEmpty: Boolean = false
  }
  case class Branch[T](v: T, left: Tree[T], right: Tree[T]) extends Tree[T]
  case class Leaf[T](v: T) extends Tree[T]
  case object Empty extends Tree[Nothing] {
    override def isEmpty: Boolean = true
  }

  object Tree {
    def leaf[T](v: T): Tree[T] = Leaf(v)
    def branch[T](v: T)(l: Tree[T], r: Tree[T]): Tree[T] = Branch(v, l, r)
    def empty[T]: Tree[T] = Empty
  }

  import Tree._

  val leftWiki = branch(3)(
    leaf(1),
    branch(6)(
      leaf(4),
      leaf(7)
    )
  )

  val rightWiki = branch(10)(
    empty,
    branch(14)(
      leaf(13),
      empty
    )
  )

  val tree = branch(8)(leftWiki, rightWiki)

  def deepSearch[T](tree: Tree[T], value: T): Boolean = {
    def go(tree: Tree[T], result: Boolean): Boolean = tree match {
      case _ if result     => result
      case Empty           => result
      case Leaf(v)         => v == value
      case Branch(v, l, r) => go(l, v == result) || go(r, v == result)
    }
    go(tree, result = false)
  }

  def breadthSearch[T](tree: Tree[T], value: T): Boolean = {
    @tailrec
    def go(queue: mutable.Queue[Tree[T]], result: Boolean): Boolean =
      if (result || queue.isEmpty) result
      else
      queue.dequeue() match {
        case Empty           => go(queue, result)
        case Leaf(v)         => go(queue, value == v)
        case Branch(v, l, r) =>
            if(v == result)
              go(queue, result = true)
            else  {
              queue.enqueue(l, r)
              go(queue, result = false)
            }
    }

    val queue = mutable.Queue[Tree[T]](tree)
    go(queue, result = false)
  }

  println(deepSearch(tree, 13))
  println(breadthSearch(tree, 13))
}
