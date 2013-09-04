import org.junit.runner.RunWith
import org.scalatest.FunSpec
import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.ShouldMatchers

@RunWith(classOf[JUnitRunner])
class StackTest extends FunSpec with ShouldMatchers {
  it("create stack") {
    Stack(1)
  }

  it("new stack should be empty") {
    val stack = Stack(1)

    stack.isEmpty should be(true)
    stack.size should be(0)
  }

  it("when one is pushed size should be 1") {
    val stack = Stack(1).push(0)

    stack.isEmpty should be(false)
    stack.size should be(1)
  }

  it("when one is pushed and popped stack should be empty") {
    val (_, stack) = Stack(1).push(0).pop

    stack.isEmpty should be(true)
    stack.size should be(0)
  }

  it("when pushed passed capacity should overflow") {
    intercept[Stack.Overflow] {
      Stack(2).push(0).push(0).push(0)
    }
  }

  it("when popped passed zero should underflow") {
    intercept[Stack.Underflow] {
      Stack(1).pop
    }
  }

  it("when one is pushed, one should be popped") {
    val (popped, _) = Stack(1).push(1).pop

    popped should be(1)
  }

  it("when one and two are pushed, two and one should be popped") {
    val stack = Stack(2).push(1).push(2)
    val (popped1, poppedStack) = stack.pop
    val (popped2, _) = poppedStack.pop

    popped1 should be(2)
    popped2 should be(1)
  }

  it("zero capacity stack should be illegal") {
    intercept[Stack.ZeroCapacity] {
      Stack(0)
    }

    intercept[Stack.ZeroCapacity] {
      Stack(-1)
    }
  }

  it("when one is pushed, stack should contain the one") {
    Stack(2).contains(1) should be(false)
    Stack(2).push(1).contains(1) should be(true)
    Stack(2).push(1).push(2).contains(1) should be(true)
  }

  it("last push should be on top") {
    Stack(2).push(1).top should be(1)
    Stack(2).push(1).push(2).top should be(2)
  }

  it("top of empty stack should throw empty stack") {
    intercept[Stack.StackIsEmpty]{
      Stack(1).top
    }
  }

  it("when one, two and three are pushed, should find the one, two and three") {
    val stack = Stack(3).push(1).push(2).push(3)

    stack.indexOf(3) should be(0)
    stack.indexOf(2) should be(1)
    stack.indexOf(1) should be(2)
  }
}
