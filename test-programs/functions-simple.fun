val add = (x, y) => x + y
assertResult(3)(add(1, 2))

val subtract = (x, y) => x - y
assertResult(-1)(subtract(1, 2))

val multiply = (x, y) => x * y
assertResult(2)(multiply(1, 2))

val division = (x, y) => x / y
assertResult(1)(division(2, 2))

/* remainder or modulus operator is not supported?
val reminder(x, y) = x % y
assertResult(1)(reminder(7, 3))
*/
