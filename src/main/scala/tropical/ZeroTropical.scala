package tropical

import breeze.storage.Zero

class ZeroTropical extends Zero[Tropical] {
  def zero: Tropical = Infty
}
