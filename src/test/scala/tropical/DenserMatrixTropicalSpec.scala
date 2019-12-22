package tropical

import breeze.linalg.DenseMatrix
import org.scalatest.{DiagrammedAssertions, FlatSpec}
import tropical.ZeroTropical.zeroTropical

class DenserMatrixTropicalSpec extends FlatSpec with DiagrammedAssertions {
  implicit val semiringTropical = SemiringTropical.semiringTropical
  implicit val tropicalLiteralRow = LiteralRowTropical.literalRowTropical

  "DenserMatrix" should "Tropical行列を加算出来るか" in {
    val a =
      DenseMatrix(
        (Infty, T(2d), T(4d), Infty),
        (Infty, T(0d), T(1d), T(9d)),
        (Infty, Infty, Infty, T(5d)),
        (T(3d), Infty, Infty, Infty)
      )

    val b =
      DenseMatrix(
        (Infty, T(2d), T(4d), Infty),
        (Infty, T(0d), T(1d), T(9d)),
        (Infty, Infty, Infty, T(5d)),
        (T(3d), Infty, Infty, Infty)
      )

    val res = DenseMatrix(
      (Infty, T(2.0), T(4.0), Infty),
      (Infty, T(0.0), T(1.0), T(9.0)),
      (Infty, Infty, Infty, T(5.0)),
      (T(3.0), Infty, Infty, Infty)
    )
    assert((a + b) === res)
  }

  "DenserMatrix" should "Tropical行列を乗算出来るか" in {
    val a =
      DenseMatrix(
        (Infty, T(2d), T(4d), Infty),
        (Infty, T(0d), T(1d), T(9d)),
        (Infty, Infty, Infty, T(5d)),
        (T(3d), Infty, Infty, Infty)
      )

    val res = DenseMatrix(
      (Infty, T(2d), T(3d), T(9d)),
      (T(12d), T(0d), T(1d), T(6d)),
      (T(8d), Infty, Infty, Infty),
      (Infty, T(5d), T(7d), Infty)
    )
    assert((a * a) === res)
  }

  "DenserMatrix" should "Tropical行列を累乗出来るか" in {
    val a =
      DenseMatrix(
        (Infty, T(2d), T(4d), Infty),
        (Infty, T(0d), T(1d), T(9d)),
        (Infty, Infty, Infty, T(5d)),
        (T(3d), Infty, Infty, Infty)
      )

//    val res =
//      DenseMatrix(
//        (T(12d), T(2d), T(3d), T(8d)),
//        (T(9d), T(0d), T(1d), T(6d)),
//        (Infty, T(10d), T(12d), Infty),
//        (Infty, T(5d), T(6d), T(12d))
//      )

    val res =
      DenseMatrix(
        (Infty, T(2d), T(3d), T(9d)),
        (T(12d), T(0d), T(1d), T(6d)),
        (T(8d), Infty, Infty, Infty),
        (Infty, T(5d), T(7d), Infty)
      )

    println(pow(a, 100))
    assert(pow(a, 3) === res)
  }

}
