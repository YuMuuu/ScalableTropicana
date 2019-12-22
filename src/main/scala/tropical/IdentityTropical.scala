package tropical

import breeze.generic.{MappingUFunc, UFunc}

object DotTropical extends UFunc with MappingUFunc {

  implicit object dotTropical extends Impl2[Tropical]

}
