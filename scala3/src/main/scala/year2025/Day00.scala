package year2025

import scala.io.Source

object Day00 extends App:
  private val N: Int = 0
  private val input: String = Source.fromResource(f"2025/day$N%02d.txt").mkString

  def part1(input: String) = processPart1(input)
  def part2(input: String) = processPart2(input)

  println(s"Solution to Day $N part 1 is ${part1(input)}")
  println(s"Solution to Day $N part 2 is ${part2(input)}")

  /////////////////////////////////////////////////////////////////////////////

  def processPart1(input: String) = 0

  def processPart2(input: String) = 0

