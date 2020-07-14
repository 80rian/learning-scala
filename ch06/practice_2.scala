// 2) Write a function titled "factors" that takes a number and returns a list of its factors, other than 1 and the number itself. 
// For example, factors(15) should return List(3, 5).

// Then write a new function that applies "factors" to a list of numbers. 
// Try using the list of Long numbers you generated in exercise 1. 
// For example, executing this function with the List(9, 11, 13, 15) should return List(3, 3, 5), as the factor of 9 is 3 while the factors of 15 are 3 again and 5. 
// Is this a good place to use map and flatten? Or, would a for-loop be a better fit?

def factors(x: Int) = 2 until x filter ( x % _ == 0)

val oddListMap = 1 to 20 map ( _ * 2 - 1 )

def factorsOfList(l: Seq[Int]) = l flatMap factors