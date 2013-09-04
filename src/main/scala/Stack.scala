object Stack {
  def apply(capacity: Int) = {
    if(capacity <= 0)
      throw new ZeroCapacity
    new EmptyStack(capacity)
  }

  class Overflow extends Throwable
  class Underflow extends Throwable
  class ZeroCapacity extends Throwable
  class StackIsEmpty extends Throwable
}

abstract class Stack(capacity: Int) {
  val isEmpty : Boolean
  val size : Int
  val top : Int
  val pop : (Int, Stack)
  def push (value: Int): Stack
  def contains(value: Int) : Boolean
  def indexOf(value: Int) : Int = idxOf(value, 0)
  private def idxOf(value: Int, index: Int) : Int = {
    this match {
      case EmptyStack(c) => -1
      case NonEmptyStack(c, s, v) => {
        if(value == v) index
        else s.idxOf(value, index + 1)
      }
    }
  }
}

case class EmptyStack(capacity: Int) extends Stack(capacity) {
  lazy val isEmpty = true
  lazy val size = 0
  lazy val top = throw new Stack.StackIsEmpty
  lazy val pop = throw new Stack.Underflow
  def push(value: Int): Stack = new NonEmptyStack(capacity, this, value)
  def contains(value: Int): Boolean = false
}

case class NonEmptyStack(capacity: Int, stack: Stack, value: Int) extends Stack(capacity) {
  lazy val isEmpty = false
  lazy val size = stack.size + 1
  lazy val top = value
  lazy val pop = (value, stack)
  def push(value: Int): Stack = {
    if(size == capacity)
      throw new Stack.Overflow
    new NonEmptyStack(capacity, this, value)
  }
  def contains(value: Int): Boolean = this.value == value || stack.contains(value)
}
