package tropical

import breeze.math.{Ring, Semiring}
import cats.kernel.Eq
import cats.kernel.Order.min
import cats.syntax.eq.catsSyntaxEq
import cats.{Order, Show}

object SemiringTropical {
  //  implicit val semiringCmplx: Semiring[Complex] = ringComplex
//  implicit val semiringCmplx: Semiring[Tropical] = ringTropical

//  implicit def semiringFromRing[T](implicit ring: Ring[T]): Semiring[T] = ring


  implicit object semiringTropical extends Semiring[Tropical] {
    implicit val eqTropical: Eq[Tropical] = Eq.fromUniversalEquals
    implicit val showTropical: Show[Tropical] = Show.fromToString
    implicit val orderTropical: Order[Tropical] = Order.fromLessThan {
      case (_, Infty) => true
      case (Infty, _) => false
      case (T(xd), T(yd)) => xd <= yd
    }


    override def zero: Tropical = Infty

    override def one: Tropical = T(0d)

    override def +(a: Tropical, b: Tropical): Tropical = min(a, b)

    override def *(a: Tropical, b: Tropical): Tropical =
      (a, b) match {
        case (_, Infty) => Infty
        case (Infty, _) => Infty
        case (aT: T, bT: T) => T(aT.d + bT.d)
      }

    override def ==(a: Tropical, b: Tropical): Boolean = a === b

    override def !=(a: Tropical, b: Tropical): Boolean = a =!= b
  }

}
