mutable count = 0

val add = (x, y) => {
  count = count + 1
  x + y
}

val num1 = add(1, 2)
assertResult(1)(count)

val num2 = add(1, 2)
assertResult(2)(count)
