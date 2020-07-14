val amount: Double = 100.0

val resultIf = if (amount > 0) "greater" else if (amount == 0) "same" else "less"
println(s"if/else block: $resultIf")

val resultMatch = amount match {
    case s if s > 0 => "greater"
    case s if s == 0 => "same"
    case s => "less" 
}
println(s"match block: $resultMatch")
