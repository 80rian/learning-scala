// 5) Write a function to safely wrap calls to the JVM library method System.getProperty(<String>), avoiding raised exceptions or null results. 
// System.getProperty(<String>) returns a JVM environment property value given the property’s name. 
// For example, System.getProperty("java.home") will return the path to the currently running Java instance while System.getProperty("user.timezone") returns the time zone property from the operating system. 
// This method can be dangerous to use, however, since it may throw exceptions or return null for invalid inputs. 
// Try invoking System.getProperty("") or System.getProperty("blah") from the Scala REPL to see how it responds.

// Experienced Scala developers build their own libraries of functions that wrap unsafe code with Scala’s monadic collections. 
// Your function should simply pass its input to the method and ensure that exceptions and null values are safely handled and filtered. 
// Call your function with the example property names above, including the valid and invalid ones, to verify that it never raises exceptions or returns null results.

// match
def safePropMatch(key: String) = {
    util.Try(System.getProperty(key)).toOption match {
        case Some(x) => x
        case None => "no result"
    }
}

// getOrElse
def safePropGOE(key: String) = {
    util.Try(System.getProperty(key)).getOrElse("no result")
}

// answer
def getProperty(s: String): Option[String] = {
    util.Try( System.getProperty(s) ) match {
      case util.Success(x) => Option(x)
      case util.Failure(ex) => None
    }
}