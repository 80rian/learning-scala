// 2) In the example for Array collections we used the java.io.File(<path>).listFiles operation to return an array of files in the current directory. 
// Write a function that does the same thing for a directory, and converts each entry into its String representation using the toString method. 
// Filter out any dot-files (files which begin with the character '.') and print the rest of the files separated by a semi-colon (';'). 
// Test this out in a directory on your computer that has a significant number of files.

def directoryLister(dir: String = "."): String = {
    val files = new java.io.File(dir).listFiles.toList
    val fileList = files map (_.getName) flatMap (_.split("/")) filterNot { _ startsWith "." }
    fileList.mkString("; ")
}