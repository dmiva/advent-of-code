package year2025

import org.scalatest.funsuite.AnyFunSuite
import year2025.Day03

class Day04Spec extends AnyFunSuite:

  val sample: String = """..@@.@@@@.
                         |@@@.@.@.@@
                         |@@@@@.@.@@
                         |@.@@@@..@.
                         |@@.@@@@.@@
                         |.@@@@@@@.@
                         |.@.@.@.@@@
                         |@.@@@.@@@@
                         |.@@@@@@@@.
                         |@.@.@@@.@.""".stripMargin

  test("Day04 part1") {
    assert(Day04.part1(sample) == 13)
  }
  
  test("Day04 part2") {
    assert(Day04.part2(sample) == 43)
  }