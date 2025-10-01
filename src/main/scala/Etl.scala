import scala.io.Source

object Etl {
  sealed trait Etl[A, B]:
    def extract(input: String): A
    def transform(data: A): B
    def load(data: B, output: String): Unit

  given StringImpl: Etl[List[String], List[String]] with
    def extract(input: String): List[String] =
      FileUtils.extract(input)

    def transform(data: List[String]): List[String] =
      data.map(_.toLowerCase)

    def load(data: List[String], output: String): Unit =
      FileUtils.load(data, output)

  given IntImpl: Etl[List[String], List[Int]] with
    def extract(input: String): List[String] =
        FileUtils.extract(input)

    def transform(data: List[String]): List[Int] = data.map(_.toInt).map(_*2)

    def load(data: List[Int], output: String): Unit = FileUtils.load(data, output)

  def etl[A, B](inputFilePath: String, outputFilePath: String)(using etlInstance: Etl[A, B]): Unit =
    val data = etlInstance.extract(inputFilePath)
    val transformedData = etlInstance.transform(data)
    etlInstance.load(transformedData, outputFilePath)
}
