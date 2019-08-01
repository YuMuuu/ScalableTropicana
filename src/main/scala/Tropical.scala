import cats.kernel.Eq
import cats.kernel.Order.min
import cats.{Order, Show}

sealed trait Tropical
case class T(d: Double) extends Tropical
case object Infty extends Tropical

trait Semiring[A[_]]{
  //加法
  val oplus: A => A => A
  //加法の単位元
  val zero: A
  //乗法
  val otimes: A => A => A
  //乗法の単位元
  val one: A
}

object Semiring {
  implicit val eqTropical: Eq[Tropical] = Eq.fromUniversalEquals
  implicit val showTropical: Show[Tropical] = Show.fromToString
  implicit val orderTropical: Order[Tropical] = Order.by(???)

  implicit def TropicalSemiring: Semiring[Tropical] = new Semiring[Tropical] {
    override val oplus = A => B => min(A, B)
    override val zero = Infty
    override val otimes: Tropical => Tropical => Tropical = {
      case _ => Infty => Infty
      case Infty => _ => Infty
      case (T(a: Double): Tropical) => (T(b: Double): Tropical) => (T((a + b): Double): Tropical)
    }
    override val one: Tropical = T(0d)
  }
}
