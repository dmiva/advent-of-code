import aoc2025.Day01
import org.scalatest.funsuite.AnyFunSuite

class Day01Spec extends AnyFunSuite:

  private val sample: String =
    """L68
      |L30
      |R48
      |L5
      |R60
      |L55
      |L1
      |L99
      |R14
      |L82""".stripMargin

  test("Day01") {
    assert(Day01.part1(sample) == 3)
  }
