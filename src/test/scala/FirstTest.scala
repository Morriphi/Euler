import org.junit.runner.RunWith
import org.scalatest.FunSpec
import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.ShouldMatchers

@RunWith(classOf[JUnitRunner])
class FirstTest extends FunSpec with ShouldMatchers {
  it("should pass") {
    true should be(true)
  }
}
