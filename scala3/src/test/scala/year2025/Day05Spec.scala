package year2025

import org.scalatest.funsuite.AnyFunSuite

class Day05Spec extends AnyFunSuite:
  private val N = 5

  test(f"Day$N%02d part1") 
    assert(Day05.part1(sample) == 3)

  test(f"Day$N%02d part2") 
    assert(Day05.part2(sample) == 14)

  def sample: String =
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
