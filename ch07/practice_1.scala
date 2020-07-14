// 1) The Fibonacci series starts with the numbers "1, 1" and then computes each successive element as the sum of the previous two elements. 
// We’ll use this series to get familiarized with the collections in this chapter.

// a) Write a function that returns a list of the first x elements in the Fibonacci series Can you write this with a Buffer? Would a Builder be appropriate here?

// b) Write a new Fibonacci function that adds new Fibonacci numbers to an existing list of numbers. 
// It should take a list of numbers (List[Int]) and the count of new elements to add and return a new list (List[Int]). 
// While the input list and returned lists are immutable, you should be able to use a mutable list inside your function. 
// Can you also write this function using only immutable lists? Which version, using mutable vs immutable collections, is more appropriate and readable?

// c) The Stream collection is a great solution for creating a Fibonacci series. 
// Create a stream that will generate a Fibonacci series. 
// Use it to print out the first 100 elements in the series, in a formatted report of 10 comma-delimited elements per line.

// d) Write a function that takes an element in the Fibonacci series and returns the following element in the series. 
// For example, fibNext(8) should return 13. How will you handle invalid input such as fixNext(9) ? 
// What are your options for conveying the lack of a return value to callers?


// a - Buffer
def fibbonacciBuffer(x: Int) = {
    val buf = collection.mutable.Buffer(1, 1)
    for (i <- 3 to x) buf += buf(buf.size - 2) + buf(buf.size - 1)
    buf
}

// def fib(count: Int): List[Int] = {
//     val b = List(1, 1).toBuffer
//     while(b.size < count) b += b.takeRight(2).sum
//     b.toList
// }

// b
def fibbonacciAdder(l: List[Int], count: Int): List[Int] = {
    val b = l.toBuffer
    for (i <- 1 to count) b += b.takeRight(2).sum
    b.toList
}

// def fibAdd(l: List[Int], count: Int): List[Int] = {
//     val b = l.toBuffer
//     for (i <- 1 to count) b += b.takeRight(2).sum
//     b.toList
// }

// c
def fibbonacciLazyList(a: Long, b: Long): LazyList[Long] = a #:: fibbonacciLazyList(b, a + b)
val s = fibbonacciLazyList(1, 1).take(100).toList
val text = s grouped 10 map (_.mkString(","))
text foreach println

// d
def nextFib(i: Int): Option[Long] = {
    val start = fibbonacciLazyList(1, 1)
    val preceeding = start.takeWhile(_ <= i).toList
    if (preceeding.last == i) Some(preceeding.takeRight(2).sum)
    else None
}

val x = nextFib(21)
val y = nextFib(22)