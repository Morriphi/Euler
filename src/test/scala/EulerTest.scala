import org.junit.runner.RunWith
import org.scalatest.FunSpec
import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.ShouldMatchers

@RunWith(classOf[JUnitRunner])
class EulerTest extends FunSpec with ShouldMatchers {
  it("Problem 1 - Sum Multiples of 3 and 5") {
    println((1 until 1000).filter(x => (x % 3 == 0 | x % 5 == 0)).sum)
  }

  it("Problem 2 - Even Fibonacci Numbers") {
    def fib(x: Int, y: Int) : Stream[Int] = x #:: fib(y, x+y)
    println(fib(1, 2).takeWhile(_ < 4000000).filter(_ % 2 == 0).sum)
  }
}
