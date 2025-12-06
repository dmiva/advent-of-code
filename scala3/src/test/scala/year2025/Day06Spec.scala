package year2025

import org.scalatest.funsuite.AnyFunSuite

class Day06Spec extends AnyFunSuite:
  private val N = 6

  test(f"Day$N%02d part1") 
    assert(Day06.part1(sample) == 4277556)

  test(f"Day$N%02d part2") 
    assert(Day06.part2(sample) == 3263827)
  
  def sample: String = 
    List("123 328  51 64 ", " 45 64  387 23 ", "  6 98  215 314", "*   +   *   +  ").mkString("\n")
