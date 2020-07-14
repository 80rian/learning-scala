// 3) Write a higher-order function that takes an integer and returns a function. 
// The returned function should take a single integer argument (say, "x") and return the product of x and the integer passed to the higher-order function.

def fixMult(x: Int) = (y: Int) => x * y

val threeMult = fixMult(3)
println(threeMult(4))