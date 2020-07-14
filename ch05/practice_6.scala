// 6) Write a function called "conditional" that takes a value x and two functions, p and f, and returns a value of the same type as x. 
// The p function is a predicate, taking the value x and returning a Boolean b. 
// The f function also takes the value x and returns a new value of the same type. 
// Your "conditional" function should only invoke the function f(x) if p(x) is true, and otherwise return x. 
// How many type parameters will the "conditional" function require?

def conditional[A]( x: A, p: A => Boolean, f: A => A ): A = {
    if (p(x)) f(x) else x
}

println( conditional[String]("yo", _.size > 4, _.reverse) )