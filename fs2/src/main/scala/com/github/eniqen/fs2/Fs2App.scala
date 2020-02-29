package com.github.eniqen.fs2
import _root_.fs2._
import cats.Eq
import cats.data.NonEmptyList
import cats.effect.{Concurrent, Sync, Timer}
import cats.effect.concurrent.Ref
import cats.implicits._

import scala.concurrent.duration._

object Fs2App  extends App {

  trait System extends Product with Serializable
  case object A extends System
  case object B extends System
  case object C extends System

  final case class Id(v: Int) extends AnyVal
  final case class Name(v: String) extends AnyVal
  final class Count private(val v: Long) extends AnyVal {
    def +(that: Count): Count = Count(v + that.v)
  }

  object Count {
    def apply(v: Long): Count = new Count(v)
    def empty: Count = Count(0L)
  }

  object Name {
    implicit def eqName(implicit eq: Eq[String]): Eq[Name] = Eq.instance[Name] {case (l, r) => eq.eqv(l.v, r.v)}

    object syntax {
      implicit final class NameOps(private val self: Name) extends AnyVal {
        def map(fn: String => String): Name = Name(fn(self.v))
      }
    }
  }

  trait Ctx[+S <: System] {
    def get: S
  }

  object Ctx {
    implicit val aCtx:Ctx[A.type] = new Ctx[A.type] { override def get: A.type = A }
    implicit val bCtx:Ctx[B.type] = new Ctx[B.type] { override def get: B.type = B }
    implicit val cCtx:Ctx[C.type] = new Ctx[C.type] { override def get: C.type = C }
  }

  trait Fetcher[F[_], S[_], -T] {
    def accounts(ctx: T): F[List[Id]]
    def fetch(nel: NonEmptyList[Id]): S[Name]
  }

  trait StreamFetcher[F[_], T] extends Fetcher[F, ({type S[A] = Stream[F, A]})#S, T]

  object StreamFetcher {
    def instance[F[_], T](fromCtx: T => F[List[Id]], fromIds: NonEmptyList[Id] => Stream[F, Name]): StreamFetcher[F, T] =
      new StreamFetcher[F,T] {
        override def accounts(ctx: T): F[List[Id]] = fromCtx(ctx)
        override def fetch(nel: NonEmptyList[Id]): Stream[F, Name] = fromIds(nel)
    }

    implicit def aFetcher[F[_]]: StreamFetcher[F, A.type] = ???
    implicit def bFetcher[F[_]]: StreamFetcher[F, B.type] = ???
    implicit def cFetcher[F[_]]: StreamFetcher[F, C.type] = ???

    val store: Map[System, Map[Id, List[Name]]] = ???
  }

  def start[F[_]: Concurrent: Timer]: Stream[F, Unit] =
    Stream.eval(Ref.of(Map.empty[System, Count])).flatMap { ref =>
      Stream(
        startImpl[F, A.type](ref),
        startImpl[F, B.type](ref),
        startImpl[F, C.type](ref)
      )
    }.parJoinUnbounded

  private def startImpl[F[_]: Concurrent: Timer, C <: System](ref: Ref[F, Map[System, Count]])
                                                   (implicit ctx: Ctx[C],
                                                    fetcher: StreamFetcher[F, C]): Stream[F, Unit] =

    Stream.evalSeq(fetcher.accounts(ctx.get))
    .map(Stream(_).covary[F])
    .parJoin(2)
    .evalTap(_ => ref.update(m => m.updated(ctx.get, m.getOrElse(ctx.get, Count.empty) + Count(1L))))
    .covary[F]
    .flatMap {
      id =>
      def fallBack: Id => Stream[F, Name] = id => fetcher.fetch(NonEmptyList.of(id))
        val in = restartOnError[F](
          ids = id,
          fn = fallBack,
          attempt = 5,
          delay = 3.seconds
        )

        in.through(enrich)
          .changes
          .through(broadcast)
          .handleErrorWith(err => Stream.eval(Sync[F].delay("Error while processing")) >> Stream.raiseError(err))
    }.onFinalize(ref.get >>= (result => Sync[F].delay(println(s"Processed ${result}")))).void


  private def enrich[F[_]: Sync, A]: Pipe[F, A, A] = ???

  private def broadcast[F[_]: Concurrent: Timer]: Pipe[F, Name, Name] =
    _.broadcast
      .take(2)
      .foldMap(List(_))
      .flatMap {
        case List(s1, s2) =>
          import Name.syntax._
          def isOdd: Name => Boolean = _.v.length % 2 == 0

          val odd: Stream[F, Name] =
            s1.filter(isOdd)
              .chunks
              .flatMap(ch => Stream.chunk(ch.map(_.map(_ + "odd"))))

          val even: Stream[F, Name] =
            s2.filter(!isOdd(_))
            .chunks
            .flatMap(ch => Stream.chunk(ch.map(_.map(_ + "even"))))

          odd merge even
      }

  private def restartOnError[F[_]](
    ids: Id,
    fn: Id => Stream[F, Name],
    attempt: Int,
    delay: FiniteDuration
   )(implicit F: Sync[F], T: Timer[F]): Stream[F, Name] = {

    def go(stream: Stream[F, Name], attempt: Int, delay: FiniteDuration): Pull[F, Name, Unit] =
      stream.pull.uncons.attempt.flatMap {
        case Right(Some((ch, tail))) => Pull.output(ch) >> go(tail, attempt, delay)
        case Right(None) => Pull.pure(None)
        case Left(err) if attempt < 0 => Pull.raiseError(err)
        case Left(err) =>
            Pull.eval(T.sleep(delay)) >>
            go(fn(ids), attempt - 1, delay * 2)
      }
    go(fn(ids), attempt, delay).stream
  }
}
