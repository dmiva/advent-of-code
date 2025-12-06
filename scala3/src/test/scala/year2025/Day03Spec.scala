package year2025

import org.scalatest.funsuite.AnyFunSuite

class Day03Spec extends AnyFunSuite:
  private val N = 3

  test(f"Day$N%02d part1") 
    assert(Day03.part1(sample) == 357)

  test(f"Day$N%02d part2") 
    assert(Day03.part2(sample) == 3121910778619L)
  
  def sample: String =
    """987654321111111
      |811111111111119
      |234234234234278
      |818181911112111""".stripMargin

