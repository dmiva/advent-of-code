package year2025

import org.scalatest.funsuite.AnyFunSuite

class Day04Spec extends AnyFunSuite:
  private val N = 4

  test(f"Day$N%02d part1")
    assert(Day04.part1(sample) == 13)
  
  test(f"Day$N%02d part2")
    assert(Day04.part2(sample) == 43)

  def sample: String =
    """..@@.@@@@.
      |@@@.@.@.@@
      |@@@@@.@.@@
      |@.@@@@..@.
      |@@.@@@@.@@
      |.@@@@@@@.@
      |.@.@.@.@@@
      |@.@@@.@@@@
      |.@@@@@@@@.
      |@.@.@@@.@.""".stripMargin
  