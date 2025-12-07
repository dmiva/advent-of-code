package year2025

import scala.io.Source
import scala.util.Try

object Day00 extends App:
  private val N: Int = 0
  private val input: String = Try(Source.fromResource(f"2025/day$N%02d.txt").mkString).toOption.getOrElse("")

  def part1(input: String) = processPart1(input)
  def part2(input: String) = processPart2(input)

  println(s"Solution to Day $N part 1 is ${part1(input)}")
  println(s"Solution to Day $N part 2 is ${part2(input)}")

  /////////////////////////////////////////////////////////////////////////////

  def processPart1(input: String) = 0

  def processPart2(input: String) = 0

