for (i <- 1 to 100) {
    i match {
        case x if x % 5 == 0 => println(s"$x,")
        case x => print(s"$x,")
    }
}