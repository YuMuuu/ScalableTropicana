package tropical

import breeze.generic.{MappingUFunc, UFunc}
import breeze.linalg.DenseMatrix
import tropical.SemiringTropical._
import tropical.ZeroTropical._

object IdentityTropical extends UFunc with MappingUFunc {

  implicit object identTropical extends Impl[Int, DenseMatrix[Tropical]] {
    override def apply(v2: Int): DenseMatrix[Tropical] = {
      DenseMatrix.eye[Tropical](v2)
    }
  }

}
