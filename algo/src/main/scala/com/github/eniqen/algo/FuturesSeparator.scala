package com.github.eniqen.algo
import scala.concurrent.{Await, Future}
import scala.concurrent.duration.Duration
import scala.util.{Failure, Success, Try}

/**
 * @author Mikhail Nemenko
 */
object FuturesSeparator {

  import scala.concurrent.ExecutionContext.Implicits.global

  val futures = Seq(
    Future { " Hello "}
    , Future.failed( new RuntimeException("Runtime"))
    , Future { "From" }
    , Future.failed( new IllegalArgumentException("Illegal"))
    , Future { "Hell" }
    , Future.failed( new IndexOutOfBoundsException("Index"))
  )

  val result: Future[(Seq[String], Seq[Throwable])] = futures.foldLeft(Future.successful(Seq.empty[String] -> Seq.empty[Throwable])) {
    case (acc, v) => for {
      result <- acc
      v <- wrapToTry(v)
    } yield v match {
      case Success(value)     => (value +: result._1) -> result._2
      case Failure(exception) => result._1 -> (exception +: result._2)
    }
  }

  def wrapToTry[A]: Future[A] => Future[Try[A]] = _.map(Success(_)).recover { case err => Failure(err) }

  println(Await.result(result, Duration.Inf))
}
