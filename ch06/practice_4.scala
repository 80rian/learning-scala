// 4) Write a function that takes a list of strings and returns the longest string in the list. 
// Can you avoid using mutable variables here? 
// This is an excellent candidate for the list-folding operations we studied. 
// Can you implement this with both fold and reduce? 
// Would your function be more useful if it took a function parameter that compared two strings and returned the preferred one? 
// How about if this function was applicable to generic lists, ie lists of any type?

val names = List("Harry", "Hermione", "Ron", "Snape")

// sortBy
def longestSortBy(l: List[String]): String = l.sortBy( _.size ).reverse(0)
// def longestSortBy(l: List[String]): String = l.sortBy(0 - _.size).head

// fold
def longestFold(l: List[String]): String = l.fold(""){ (x: String, y: String) => if (x.size >= y.size) x else y }

// reduce
def longestReduce(l: List[String]): String = l.reduce{(x: String, y: String) => if (x.size >= y.size) x else y  }

// function parameter
def preferedString[A](l: List[A], f: (A, A) => A): A = l.reduce(f(_, _))
preferedString[String](names, (x, y) => if (x.size > y.size) x else y)