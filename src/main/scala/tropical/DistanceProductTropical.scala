package tropical

import breeze.generic.{MappingUFunc, UFunc}
import breeze.linalg.DenseMatrix
import breeze.linalg.operators.OpMulMatrix

object distanceProduct extends UFunc with MappingUFunc {

  implicit object distanceProductTropical extends OpMulMatrix.Impl2[DenseMatrix[Tropical], DenseMatrix[Tropical], DenseMatrix[Tropical]] {
    override def apply(v: DenseMatrix[Tropical], v2: DenseMatrix[Tropical]): DenseMatrix[Tropical] = v * v2
  }

}
