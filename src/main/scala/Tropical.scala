import breeze.linalg.{DenseMatrix, DenseVector}
import breeze.math.{Field, Ring, Semiring}
import breeze.storage.Zero
import cats.kernel.Eq
import cats.kernel.Order.min
import cats.{Order, Show}
import cats.implicits._

import scala.reflect.ClassTag

sealed trait Tropical
case class T(d: Double) extends Tropical
case object Infty extends Tropical

class TropicalSemiring extends Semiring[Tropical] {
  implicit val eqTropical: Eq[Tropical] = Eq.fromUniversalEquals
  implicit val showTropical: Show[Tropical] = Show.fromToString
  implicit val orderTropical: Order[Tropical] = Order.fromLessThan {
    case (_, Infty)     => true
    case (Infty, _)     => false
    case (T(xd), T(yd)) => xd <= yd
  }

  override def zero: Tropical = Infty
  override def one: Tropical = T(0d)
  override def +(a: Tropical, b: Tropical): Tropical = min(a, b)
  override def *(a: Tropical, b: Tropical): Tropical =
    (a, b) match {
      case (_, Infty)     => Infty
      case (Infty, _)     => Infty
      case (aT: T, bT: T) => T(aT.d + bT.d)
    }
  override def ==(a: Tropical, b: Tropical): Boolean = a === b
  override def !=(a: Tropical, b: Tropical): Boolean = a =!= b
}

class LinearAlgebra[A <: Zero[A]: ClassTag: Semiring] extends TropicalSemiring {
  implicit def zeroFromSemiring[T: Semiring] =
    Zero(implicitly[Semiring[T]].zero)

  val dim: DenseVector[A] => Int = _.length
  val ident: Int => DenseMatrix[A] = DenseMatrix.eye[A](_)
}
