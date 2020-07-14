// 3) Take the file listing from exercise 3 and print a report showing each letter in the alphabet followed by the number of files that start with that letter.


def directoryLister(dir: String = "."): List[String] = {
    val files = new java.io.File(dir).listFiles.toList
    files map (_.getName) flatMap (_.split("/")) filterNot { _ startsWith "." }
}

val fl = directoryLister("./ch07")

// for (i <- 'a' to 'z') {
//     val size = fl.filter(_ startsWith i.toString).size
//     println(s"$i: $size")
// }

val fileLookup = fl.groupBy(_.head.toLower).toList.sortBy(_._1)
for { (c,l) <- fileLookup } { println(s"'$c' has ${l.size} files") }