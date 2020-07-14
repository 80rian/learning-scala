// 4) Let’s say that you happened to run across this function while reviewing another developer’s code:
// def fzero[A](x: A)(f: A ⇒ Unit): A = { f(x); x }
// What does this function accomplish? Can you give an example of how you might invoke it?

def fzero[A](x: A)(f: A ⇒ Unit): A = { f(x); x }

println( fzero("hi"){ s => println( s.reverse )} )
println( fzero[Boolean](false) { b => println(s"b was $b") } )