// 3) Write a function, first[A](items: List[A], count: Int): List[A], that returns the first x number of items in a given list. 
// For example, first(List('a','t','o'), 2) should return List('a','t'). 
// You could make this a one-liner by invoking one of the built-in list operations that already performs this task, or (preferably) implement your own solution. 
// Can you do so with a for-loop? With foldLeft? With a recursive function that only accessed head and tail?

val chars = ('a' to 'f').toList

// builtin
def firstBuiltIn[A](items: List[A], count: Int): List[A] = items take count

// for
def firstFor[A](items: List[A], count: Int): List[A] = (for(i <- 0 until count) yield items(i)).toList

// foldLeft
def firstFoldLeft[A](items: List[A], count: Int): List[A] = {
    items.foldLeft[List[A]](Nil) { ( a: List[A], i: A) =>
        if (a.size >= count) a else i :: a
    }.reverse
}

// recursive
def firstRecursive[A](items: List[A], count: Int): List[A] = {
    if (count > 0 && items.tail != Nil) items.head :: first(items.tail, count - 1)
    else Nil
}