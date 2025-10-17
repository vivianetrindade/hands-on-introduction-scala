import Etl.*


@main def run: Unit =
  val input: String = "src/main/resources/input.txt"
  val output: String = "src/main/resources/output.txt"

  import Etl.IntImpl
  etl(input, output) match {
    case Left(error) => println(s"ETL process failed with error: $error")
    case Right(_)    => println(s"ETL process completed successfully.")
  }
