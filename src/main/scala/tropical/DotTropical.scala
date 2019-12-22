package tropical

import breeze.generic.{MappingUFunc, UFunc}
import breeze.linalg.DenseVector
import breeze.linalg.operators.OpMulMatrix

object DotTropical extends UFunc with MappingUFunc {

  implicit object dotTropical extends OpMulMatrix.Impl2[DenseVector[Tropical], DenseVector[Tropical], Tropical] {
    override def apply(v: DenseVector[Tropical], v2: DenseVector[Tropical]): Tropical = v * v2
  }


}
