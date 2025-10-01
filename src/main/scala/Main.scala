import Etl._

@main def run: Unit =
  val input: String = "src/main/resources/input.txt"
  val output: String = "src/main/resources/output.txt"
  etl(input, output)(using Etl.IntImpl)


