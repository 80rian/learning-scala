val color = "cyan"

val result = color match {
    case "cyan" => "00ffff"
    case "magneta" => "00ff00"
    case "yellow" => "ffff00"
    case _ => "Error! Wrong Input!"
}

println(result)