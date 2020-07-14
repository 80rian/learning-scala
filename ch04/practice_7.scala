// 7. Write a function that takes a 2-sized tuple and returns it with the Int value (if included) in the first position. 
// Hint: this would be a good use for type parameters and the isInstanceOf type operation.

// def switcher[A](item: (A, A)): (A, A) = {
//     if (item._1.isInstanceOf[Int]) item
//     else null
// }

// println(switcher('1', 1))

def intFirst[A,B](t: (A,B)): (Any,Any) = {
    def isInt(x: Any) = x.isInstanceOf[Int]
        (isInt(t._1), isInt(t._2)) match {
            case (false, true) => (t._2, t._1)
            case _ => t
    }
}