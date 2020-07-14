// 6) Write a function that reports recent Github commits for a project. 
// Github provides an RSS feed of recent commits for a given user, repository and branch, containing xml that you can parse out with regular expressions. 
// Your function should take the user, repository and branch, read and parse the RSS feed, and then print out the commit information. 
// This should include the date, title and author of each commit.

// You can use the following RSS url to retrieve recent commits for a given repository and branch:

// https://github.com/<user name>/<repo name>/commits/<branch name>.atom
// Here is one way to grab the RSS feed as a single string.

// scala> val u = "https://github.com/scala/scala/commits/2.11.x.atom"
// u: String = https://github.com/scala/scala/commits/2.11.x.atom

// scala> val s = io.Source.fromURL(u)
// s: scala.io.BufferedSource = non-empty iterator

// scala> val text = s.getLines.map(_.trim).mkString("")
// text: String = <?xml version="1.0" encoding="UTF-8"?><feed xmlns=...
// Working with the xml will be a bit tricky. You may want to use +text.split(<token>) to split the text into the separate <entry> components, and then use regular expression capture groups (see [regular_expressions_section]) to parse out the <title> and other elements. 
// You could also just try iterating through all the lines of the xml file, adding elements to a buffer as you find them, and then converting that to a new list.

// Once you have completed this exercise (and there is a lot to do here), here are some additional features worth investigating. 
// a) Move the user, repo and branch parameters into a tuple parameter. 
// b) Following exercise "a", have the function take a list of Github projects and print a report of each one’s commits, in order of specified project. 
// c) Following exercise "b", retrieve all of the projects commit data concurrently using futures, await the result (no more than 5 seconds), and then print a commit report for each project, in order of project specified. 
// d) Following exercise "c", mix the commits together and sort by commit date, then print your report with an additional "repo" column.

// These additional features will take some time to implement, but are definitely worthwhile for learning and improving your Scala development skills.

// Once you have finished these features, test out your commit report using entries from the following projects.

// https://github.com/akka/akka/tree/master
// https://github.com/scala/scala/tree/2.11.x
// https://github.com/sbt/sbt/tree/0.13
// https://github.com/scalaz/scalaz/tree/series/7.2.x
// These features are all active (as of 2014), so you should see an interesting mix of commit activity in your report. 
// Its worthwhile to browse the repositories for these core open source Scala projects, or at least their documentation, to understand some of the excellent work being done.

def xmlLoad(username: String = "80rian", repo: String = "learning-scala", branch: String = "master") = {
    val url = s"https://github.com/$username/$repo/commits/$branch.atom"
    val res = io.Source.fromURL(url)
    val text = res.getLines.map(_.trim).mkString("")
    text
}
val xml = xmlLoad()

def xmlToEntryList(xml: String) = xml.split("</?entry>").filterNot(_.isEmpty).tail
val entries = xmlToEntryList(xml); println(s"Got ${entries.size} entries")

def child(xml: String, name: String): Option[String] = {
    val p = s".*<$name>(.*)</$name>.*".r
    xml match {
      case p(result) => Option(result)
      case _ => None
    }
}
val firstTitle = child(entries(0), "title")

def report(entryXml: String): Option[String] = {
    for {
      title <- child(entryXml, "title")
      date <- child(entryXml, "updated").map(_.replaceAll("T.*",""))
      author <- child(entryXml, "name")
    }
    yield s"title:  $title\ndate:   $date\nauthor: $author"
}
val firstReport = report(entries(0))


def getGithubReport(user: String, repo: String, branch: String): String = {
    val xml = xmlLoad(user, repo, branch)
    val entries = xmlToEntryList(xml).toList
    val formattedEntries = entries flatMap report
    val title = s"Github commit activity for $repo:$branch"
    title :: formattedEntries mkString ("\n" + "=" * 80 + "\n")
}

val slickReport = getGithubReport("80rian", "learning-scala", "master")