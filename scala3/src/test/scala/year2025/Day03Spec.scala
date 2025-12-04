package year2025

import org.scalatest.funsuite.AnyFunSuite
import year2025.Day03

class Day03Spec extends AnyFunSuite:

  private val sample: String = """987654321111111
                                 |811111111111119
                                 |234234234234278
                                 |818181911112111""".stripMargin
  
  test("Day03 part1") {
    assert(Day03.part1(sample) == 357)
  }

  test("Day03 part2") {
    assert(Day03.part2(sample) == 0)
  }
