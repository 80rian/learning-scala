// 5) Write a function that reverses a list. 
// Can you write this as a recursive function? This may be a good place for a match expression.

val names = List("Harry", "Hermione", "Ron", "Snape")

// built-in
def reverser[A](l: List[A]): List[A] = l.reverse

// recursive
def reverserRecursive[A](src: List[A], dest: List[A] = Nil): List[A] = {
    if (src == Nil) dest else reverse(src.tail, src.head :: dest)
}