package tropical

import breeze.generic.{MappingUFunc, UFunc}
import breeze.linalg.DenseVector

object DotTropical extends UFunc with MappingUFunc {

  implicit object dotTropical extends Impl2[DenseVector[Tropical], DenseVector[Tropical], Tropical] {
    override def apply(v: DenseVector[Tropical], v2: DenseVector[Tropical]): Tropical = v * v2
  }


}
