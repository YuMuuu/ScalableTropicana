package tropical

sealed trait Tropical extends Serializable with Product
case class T(d: Double) extends Tropical
case object Infty extends Tropical
