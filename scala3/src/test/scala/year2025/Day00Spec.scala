package year2025

import org.scalatest.funsuite.AnyFunSuite

class Day00Spec extends AnyFunSuite:
  private val N = 0

  test(f"Day$N%02d part1")
    assert(Day00.part1(sample) == 0)

  test(f"Day$N%02d part2")
    assert(Day00.part2(sample) == 0)

  def sample: String =
    """""".stripMargin
