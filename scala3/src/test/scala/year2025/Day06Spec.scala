package year2025

import org.scalatest.funsuite.AnyFunSuite
import year2025.Day03

class Day06Spec extends AnyFunSuite:

  val sample: String =
    """123 328  51 64
      | 45 64  387 23
      |  6 98  215 314
      |*   +   *   +  """.stripMargin

  test("Day06 part1") {
    assert(Day06.part1(sample) == 4277556)
  }
