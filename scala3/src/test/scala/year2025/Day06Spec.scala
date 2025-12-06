package year2025

import org.scalatest.funsuite.AnyFunSuite
import year2025.Day03

class Day06Spec extends AnyFunSuite:

  val sample: String = List("123 328  51 64 ", " 45 64  387 23 ", "  6 98  215 314", "*   +   *   +  ").mkString("\n")

  test("Day06 part1") {
    assert(Day06.part1(sample) == 4277556)
  }

  test("Day06 part2") {
    assert(Day06.part2(sample) == 3263827)
  }
