package com.github.eniqen.algo

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
object Tree extends App {
  sealed trait Tree[+T]
  case class Branch[T](v: T, left: Tree[T], right: Tree[T]) extends Tree[T]
  case class Leaf[T](v: T) extends Tree[T]
  case object Empty extends Tree[Nothing]

  object Tree {
    def leaf[T](v: T): Tree[T] = Leaf(v)
    def branch[T](v: T)(l: Tree[T], r: Tree[T]): Tree[T] = Branch(v, l, r)
    def empty[T]: Tree[T] = Empty
  }

  import Tree._

  val left = branch(1, Empty)
  val right = branch(
    branch(
      leaf(7),
      branch(
        leaf(8),
        leaf(9)
      )
    ),
    leaf(10)
  )

  val tree: Tree[Int] = branch(7)(
    branch(1)(
      empty,
      branch(3)(
        leaf(2),
        leaf(4)
      )
    ),
    branch(5)(
      branch(6)(
        branch(7)(
          empty,
          leaf(7)
        ),
        leaf(10)
      ),
      empty
    )
  )

  def deepSearch[T](tree: Tree[T]) = ???

  def breadthSearch[T](tree: Tree[T]) = ???
}
