package com.github.eniqen.common

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
object SimpleHandler extends App {
  import scala.language.implicitConversions

  import Handle._

  case class AS(currentState: S)
  val None = AS(A)

  trait Handle[-E] {
    def handle(context: AS, event: E): AS
  }



  object Handle {
    import transitions._
    implicit final class HandleOps(state: AS) {
      def handleEvent[E](e: E)(implicit H: Handle[E]): AS =
        H.handle(this.state, e)

      def handleAll[E](events: Instance[Handle]*): AS =
        events.foldLeft(this.state) { case (s, e) => e.instance.handle(s, e.value) }
    }

    trait Instance[F[_]] {
      type Type
      val value: Type
      implicit val instance: F[Type]
    }
    object Instance {
      implicit def instance[F[_], T](t: T)(implicit ev: F[T]): Instance[F] = new Instance[F] {
        type Type = T
        val value = t
        val instance = ev
      }
    }

    sealed trait S
    case object A extends S
    case object O extends S
    case object R extends S
    case object U extends S

    object transitions {
      case class HangUp(sessionId: Int)
      case class PickUp(sessionId: Int)
      case class ExtensionEvent(extensionStatus: AS)
      case object Timeout

      trait HangUpFor[T]
      case object HangUpEmpty
      case object HangUpNotEmpty

      implicit val whenPickUp: Handle[PickUp] = new Handle[PickUp] {
        override def handle(context: AS, event: PickUp): AS =
          context.currentState match {
            case _: A.type => context.copy(O)
            case _: O.type => context
            case _: R.type => context
            case _: U.type => context
          }
      }

      implicit val whenHangUp: Handle[HangUp] = new Handle[HangUp] {
        override def handle(context: AS, event: HangUp): AS =
          context.currentState match {
            case _: A.type => context
            case _: O.type => context.copy(U)
            case _: R.type => context
            case _: U.type => context
          }
      }

      implicit val whenExtensionEvent: Handle[ExtensionEvent] =
        new Handle[ExtensionEvent] {
          override def handle(context: AS, event: ExtensionEvent): AS =
            context.currentState match {
              case _: A.type => context
              case _: O.type => context
              case _: R.type => context
              case _: U.type => context
            }
        }

      implicit val whenTimeout: Handle[Timeout.type] = new Handle[Timeout.type] {
        override def handle(context: AS, event: Timeout.type): AS =
          context.currentState match {
            case _: A.type => context
            case _: O.type => context
            case _: R.type => context
            case _: U.type => context
          }
      }
    }
  }
  import Handle.transitions._
  println(None.handleEvent(PickUp(5)).handleEvent(HangUp(10)))



  println(None.handleAll(PickUp(5), HangUp(1)))
}
