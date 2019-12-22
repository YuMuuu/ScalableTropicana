package tropical

import breeze.generic.{MappingUFunc, UFunc}

object distanceProduct extends UFunc with MappingUFunc {

  implicit object distanceProductTropical extends Impl2[Tropical, Tropical, Tropical] {
    override def apply(v: Tropical, v2: Tropical): Tropical = ???
  }
}
