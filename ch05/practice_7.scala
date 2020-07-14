// 7) Do you recall the "typesafe" challenge from the exercises in [expressions_ch]? 
// There is a popular coding interview question I’ll call "typesafe", in which the numbers 1 - 100 must be printed one per line. 
// The catch is that multiples of 3 must replace the number with the word "type", while multiples of 5 must replace the number with the word "safe". 
// Of course, multiples of 15 must print "typesafe".

// Use the "conditional" function from exercise 6 to implement this challenge.

// Would your solution be shorter if the return type of "conditional" did not match the type of the parameter x? 
// Experiment with an altered version of the "conditional" function that works better with this challenge.


// // 1
// def conditional[A]( x: A, p: A => Boolean, f: A => A ): A = {
//     if (p(x)) f(x) else x
// }

// for (i <- 1 to 100) {
//     val a1 = conditional[Int](i, _ % 3 == 0, x => { print("type"); 0 })
//     val a2 = conditional[Int](i, _ % 5 == 0, x => { print("safe"); 0 })
//     if (a1 > 0 && a2 > 0) print(i)
//     println("")
// }

// // 2
// def conditional2[A](x: A, p: A => Boolean, f: A => String): String = {
//     if (p(x)) f(x) else ""
// }

// for (i <- 1 to 100) {
//     val a1 = conditional2[Int](i, _ % 3 == 0, _ => "type")
//     val a2 = conditional2[Int](i, _ % 5 == 0, _ => "safe")
//     val a3 = conditional2[Int](i, _ % 3 > 0 && i % 5 > 0, x => s"$x")
//     println(a1 + a2 + a3)
// }

// // 3
def conditional3[A](x: A, p: A => Boolean, f: A => String): String = {
    if (p(x)) f(x) else ""
}

def typeSafely(i: Int): String = {
    val a1 = conditional3[Int](i, _ % 3 == 0, _ => "type")
    val a2 = conditional3[Int](i, _ % 5 == 0, _ => "safe")
    val a3 = conditional3[Int](i, _ % 3 > 0 && i % 5 > 0, x => s"$x")
    a1 + a2 + a3
}

val sequence = 1 to 100 map typeSafely