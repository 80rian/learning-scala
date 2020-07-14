// 5) There’s a function named "square" that you would like to store in a function value. 
// Is this the right way to do it? How else can you store a function in a value?

// def square(m: Double) = m * m
// val sq = square

// val square: Double => Double = Math.pow(_, 2)

// println( square(4) )


def square(m: Double) = m * m

val sq1 = square _
val sq2: Double => Double = square