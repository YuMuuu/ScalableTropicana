package tropical

import breeze.generic.{MappingUFunc, UFunc}
import breeze.linalg.DenseMatrix
import breeze.linalg.operators.OpAdd

object MatrixPlusTropical extends UFunc with MappingUFunc {

  implicit object matrixPlusTropical extends OpAdd.Impl2[DenseMatrix[Tropical], DenseMatrix[Tropical], DenseMatrix[Tropical]] {
    override def apply(v: DenseMatrix[Tropical], v2: DenseMatrix[Tropical]): DenseMatrix[Tropical] = v + v2
  }
}
