import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration

object PascalTriangle {

  def main(args: Array[String]): Unit = {
    val levels: Int = args(0).toInt
    val printFlag: Boolean = args mkString " " contains "-print"
    val res = pascalTriangle(levels, 0, printFlag)
    Await.ready(res, Duration.Inf)
  }

  def pascalTriangle(level: Int, line: Int = 0, printFlag: Boolean): Future[Unit] = {
    def elem(i: Int, j: Int): Int =
      if (j >= i || j == 0) 1
      else elem(i-1, j-1) + elem(i-1, j)
    val formatLine: Future[String] = Future {(0 to line) map {elem(line, _).toString} mkString " "}
    val sideEffects: Future[Unit] = formatLine.map {v =>
      if (printFlag) println(v)
    }
    if (line < level) pascalTriangle(level, line+1, printFlag)
    else sideEffects
  }

}

