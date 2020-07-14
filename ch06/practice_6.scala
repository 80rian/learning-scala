// 6) Write a function that takes a List[String] and returns a (List[String],List[String]), a tuple of string lists. 
// The first list should be items in the original list that are palindromes (written the same forwards and backwards, like "racecar"). 
// The second list in the tuple should be all of the remaining items from the original list. 
// You can implement this easily with partition, but are there other operations you could use instead?

val pallies = List("Hi", "otto", "yo", "racecar")

// partition
def palindromePartition(l: List[String]): (List[String], List[String]) = {
    l partition {x:String => x.reverse == x}
}

// foldLeft
def splitPallies(l: List[String]) = {
    l.foldLeft((List[String](),List[String]())) { (a, i) =>
      if (i == i.reverse) (i :: a._1, a._2) else (a._1, i :: a._2)
    }
}