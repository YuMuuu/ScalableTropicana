package tropical

import breeze.linalg.support.LiteralRow

trait LiteralRowTropical extends LiteralRow[Array[Tropical], Tropical]

object LiteralRowTropical {
  implicit object literalRowTropical extends LiteralRowTropical {
    //todo: 要パフォーマンス検証
    override def foreach[X](arr: Array[Tropical],
                            fn: (Int, Tropical) => X): Unit =
      arr.zipWithIndex.foreach { case (e, i) => fn(i, e) }

    override def length(arr: Array[Tropical]): Int = arr.length
  }
}
