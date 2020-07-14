// 8) Write a function that takes a 3-sized tuple and returns a 6-sized tuple, with each original parameter followed by its String representation. 
// For example, invoking the function with (true, 22.25, "yes") should return (true, "true", 22.5, "22.5", "yes", "yes"). 
// Can you ensure that tuples of all possible types are compatible with your function? When you invoke this function, can you do so with explicit types not only in the function result but in the value that you use to store the result?

def sixTuple[A, B, C](item: (A, B, C)): (A, String, B, String, C, String) = {
    (item._1, item._1.toString, item._2, item._2.toString, item._3, item._3.toString)
}

println(sixTuple(true, 22.25, "yes"))