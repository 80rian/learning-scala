// 2) The library function util.Random.nextInt returns a random integer. 
// Use it to invoke the "max" function with two random integers plus a function that returns the larger of two given integers. 
// Do the same with a function that returns the smaller of two given integers, and then a function that returns the second integer every time.

def nextInt = util.Random.nextInt
val t = (nextInt, nextInt, nextInt)
println(s"t: $t")

def pickOne(item: (Int, Int, Int), f: (Int, Int) => Int): Int = {
    f(f(item._1, item._2), item._3)
}



// 1 - max
val max = (a: Int, b: Int) => if (a > b) a else b
println(s"max: ${pickOne(t, max)}")

// 2 - min
println(s"min: ${pickOne(t, (a: Int, b: Int) => if (a < b) a else b)}")

// 3 - second
// can't figure out but the author says,
println(s"second: ${pickOne(t, (a: Int, b: Int) => a)}")