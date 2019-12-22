package tropical

import breeze.generic.{MappingUFunc, UFunc}
import breeze.linalg.DenseVector

object pow extends UFunc with MappingUFunc {
  val dim: DenseVector[Tropical] => Int = _.length

  implicit val zeroToropical = ZeroTropical.zeroTropical

  implicit object powTropical extends Impl2[Tropical, Int, Tropical] {
    override def apply(v: Tropical, v2: Int): Tropical = ???
  }
}
