val name = "Adrian"

val result = name match {
    case s if s.size > 0 => s
    case s => "n/a"
}

println(result)


/*
val name = "Dresden"
name match {
    case "" => "n/a"
    case n => n
}
*/