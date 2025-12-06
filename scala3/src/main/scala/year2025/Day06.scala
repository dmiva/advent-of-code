package year2025

import scala.io.Source

object Day06 extends App:
  private val N: Int = 6
  private val input: String = Source.fromResource(f"2025/day$N%02d.txt").mkString

  def part1(input: String) = processPart1(input)
  val answer1 = part1(input)
  println(s"Solution to part 1 is $answer1")

  def part2(input: String) = processPart2(input)
  val answer2 = part2(input)
  println(s"Solution to part 2 is $answer2")

  /////////////////////////////////////////////////////////////////////////////

  def processPart1(input: String) =
    input
      .linesIterator
      .map(_.trim.split("\\s+").toList)
      .toList
      .transpose
      .map(_.reverse)
      .map {
        case "*" :: numbers => numbers.map(_.toLong).product
        case "+" :: numbers => numbers.map(_.toLong).sum
        case _ => 0
      }
      .sum

  def processPart2(input: String) = 0

