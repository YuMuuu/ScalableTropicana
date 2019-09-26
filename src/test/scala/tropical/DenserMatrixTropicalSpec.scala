package tropical

import breeze.linalg.DenseMatrix
import org.scalatest.{DiagrammedAssertions, FlatSpec}

class DenserMatrixTropicalSpec extends FlatSpec with DiagrammedAssertions {
  implicit val semiringTropical = SemiringTropical.semiringTropical
  implicit val tropicalLiteralRow = new LiteralRowTropical
  implicit val zero = new ZeroTropical

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
      (Infty, T(2.0), T(3.0), T(9.0)),
      (T(12.0), T(0.0), T(1.0), T(6.0)),
      (T(8.0), Infty, Infty, Infty),
      (Infty, T(5.0), T(7.0), Infty)
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

    val res = DenseMatrix(
      (Infty, T(2.0), T(3.0), T(9.0)),
      (T(12.0), T(0.0), T(1.0), T(6.0)),
      (T(8.0), Infty, Infty, Infty),
      (Infty, T(5.0), T(7.0), Infty)
    )
//    println(a ^:^ 3)
//    assert((a :^ 3) === res)
  }
}
