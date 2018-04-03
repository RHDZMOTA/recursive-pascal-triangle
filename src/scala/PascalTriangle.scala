
object PascalTriangle {

  def main(args: Array[String]): Unit = {
    val levels: Int = args(0).toInt
    val printFlag: Boolean = args mkString " " contains "-print"
    pascalTriangle(levels, 0, printFlag)
  }

  def pascalTriangle(level: Int, line: Int = 0, printFlag: Boolean = true): Unit = {
    def elem(i: Int, j: Int): Int = 
      if (j >= i || j == 0) 1 else elem(i-1, j-1) + elem(i-1, j)
    val formatLine: String = (0 to line) map {elem(line, _).toString} mkString " "
    if (printFlag) println(formatLine)
    if (line < level) pascalTriangle(level, line+1, printFlag)
  }

}
