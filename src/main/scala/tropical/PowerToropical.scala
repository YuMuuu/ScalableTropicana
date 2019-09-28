package tropical

import breeze.generic.{MappingUFunc, UFunc}
import tropical.SemiringTropical.semiringTropical

object pow extends UFunc with MappingUFunc {

  private implicit class multipul(n: Tropical) {
    def *(m: Tropical): Tropical = semiringTropical.*(n, m)
  }

  implicit object powTropical extends Impl2[Tropical, Int, Tropical] {
    override def apply(v: Tropical, v2: Int): Tropical =
      List.fill(v2)(v).foldLeft(T(0d): Tropical) { (acc, z) =>
        acc * z
      }
  }
}
