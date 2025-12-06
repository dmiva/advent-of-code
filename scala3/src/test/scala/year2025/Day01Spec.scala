package year2025

import org.scalatest.funsuite.AnyFunSuite

class Day01Spec extends AnyFunSuite:
  private val N = 1

  test(f"Day$N%02d part1")
    assert(Day01.part1(sample) == 3)

  test(f"Day$N%02d part2")
    assert(Day01.part2(sample) == 6)

  def sample: String =
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
