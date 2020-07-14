// 4) Write a function to return the product of two numbers.. that are each specified as a String, not a numeric type. 
// Will you support both integers and floating-point numbers? 
// How will you convey if either or both of the inputs are invalid? 
// Can you handle the converted numbers using a match expression? How about with a for-loop?

def stringProduct(x: String, y: String): Double = {
    util.Try(x.toDouble, y.toDouble) match {
        case util.Success((a, b)) => a * b
        case util.Failure(error) => throw new Exception("not a number")
    }    
}


// answer
def toDouble(a: String) = util.Try(a.toDouble).toOption
val x = toDouble("a")

def product(a: String, b: String): Option[Double] = {
    (toDouble(a), toDouble(b)) match {
    case (Some(a1), Some(b1)) => Some(a1 * b1)
    case _ => None
    }
}

val x = product("yes", "20")
val x = product("99.3", "7")