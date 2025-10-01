import org.scalatest._
import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should.Matchers
import Challenges._

class ChallengesSpec extends AnyFreeSpec with Matchers {
  "calculateSum" - {
    "returns 0 for an empty list" in {
      val emptyList = List.empty[Int]
      val result = calculateSum(emptyList)

      result shouldBe 0
    }
    "calculates the sum of a list of integers" in {
      val numberList = List(1, 2, 3, 4, 5)
      val expectedSum = 15
      val result = calculateSum(numberList)

      result shouldBe expectedSum
    }
    "handles negative numbers correctly" in {
      val numberList = List(-1, -2, -3, 4, 5)
      val expectedSum = 3
      val result = calculateSum(numberList)

      result shouldBe expectedSum
    }
  }

  "filterAndConvert" - {
    "filters names with less than four characters and converts them to uppercase" in {
      val inputNames = List("Ravi", "Akiko", "Satoshi", "Priya", "Juan", "Bola")
      val expectedOutput = List("RAVI", "JUAN", "BOLA")
      val result = filterAndConvert(inputNames)
      result shouldBe expectedOutput
    }

    "returns an empty list when there are no names with less than four characters" in {
      val inputNames = List("Michael", "Sophia", "William")
      val result = filterAndConvert(inputNames)
      result shouldBe empty
    }
  }
}
