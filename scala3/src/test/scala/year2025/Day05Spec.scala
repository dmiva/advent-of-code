package year2025

import org.scalatest.funsuite.AnyFunSuite
import year2025.Day03

class Day05Spec extends AnyFunSuite:

  val sample: String =
    """3-5
      |10-14
      |16-20
      |12-18
      |
      |1
      |5
      |8
      |11
      |17
      |32""".stripMargin

  test("Day05 part1") {
    assert(Day05.part1(sample) == 3)
  }
