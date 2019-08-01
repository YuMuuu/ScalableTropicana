import cats.kernel.Eq
import cats.kernel.Order.min
import cats.{Order, Show}

sealed trait Tropical
case class T(d: Double) extends Tropical
case object Infty extends Tropical

trait Semiring[A[_]]{
  val oplus: A => A => A
  val zero: A
  val otimes: A => A => A
  val one: A
}

object Semiring {
  implicit val eqTropical: Eq[Tropical] = Eq.fromUniversalEquals
  implicit val showTropical: Show[Tropical] = Show.fromToString
  implicit val orderTropical: Order[Tropical] = Order.fromLessThan {
    case (_, Infty)     => true
    case (Infty, _)     => false
    case (T(xd), T(yd)) => xd <= yd
  }

  implicit def TropicalSemiring: Semiring[Tropical] = new Semiring[Tropical] {
    override val oplus = A => B => min(A, B)
    override val zero = Infty
    override val otimes: Tropical => Tropical => Tropical = {
      case _ => Infty => Infty
      case Infty => _ => Infty
      case ta:T => tb:T => T(ta.d + tb.d)
    }
    override val one: Tropical = T(0d)
  }
}
