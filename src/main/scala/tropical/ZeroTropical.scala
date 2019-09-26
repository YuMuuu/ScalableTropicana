package tropical

import breeze.storage.Zero

trait ZeroTropical extends Zero[Tropical]
object ZeroTropical {
  implicit object zeroTropical extends ZeroTropical {
    def zero: Tropical = Infty
  }
}
