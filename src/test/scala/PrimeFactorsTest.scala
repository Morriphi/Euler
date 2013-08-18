import org.junit.runner.RunWith
import org.scalatest.FunSpec
import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.ShouldMatchers

@RunWith(classOf[JUnitRunner])
class PrimeFactorsTest extends FunSpec with ShouldMatchers {
  Map(
    1 -> List(),
    2 -> List(2),
    3 -> List(3),
    4 -> List(2, 2),
    6 -> List(2, 3),
    8 -> List(2, 2, 2),
    9 -> List(3, 3))
    .foreach(runTest)

  def runTest(map: (Int, List[Int])) = {
    val n = map._1
    val primes = map._2
    it(s"Prime factors of $n should be $primes") {
      PrimeFactorsOf(n) should be(primes)
    }
  }
}
