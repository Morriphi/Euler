object PrimeFactorsOf {
  def apply(n: Long): List[Long] = {
    def f(n: Long, candidate: Long): List[Long] = {
      if (n <= 1) List()
      else if (n % candidate == 0) candidate :: f(n / candidate, candidate)
      else f(n, candidate+1)
    }
    f(n, 2)
  }
}
