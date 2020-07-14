// 1) Write a function literal that takes two integers and returns the higher number. 
// Then write a higher-order function that takes a 3-sized tuple of integers plus this function literal, and uses it to return the maximum value in the tuple.

val max = (a: Int, b: Int) => if (a > b) a else b

// println( max(23, 32) )

def maxThree(item: (Int, Int, Int), f: (Int, Int) => Int): Int = {
    f(f(item._1, item._2), item._3)
}

println( maxThree((3, 5, 7), max) )