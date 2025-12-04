package year2025

import scala.io.Source

object Day03 extends App:
  private val input = Source.fromResource("2025/day03.txt").mkString

  def part1(input: String) = input
    .linesIterator
    .map(_.map(_.asDigit)
    .foldRight((0, 0)) { case (n, (maxDoubleDigit, maxSingleDigit)) =>
      val newMaxSingle = if (n > maxSingleDigit) n else maxSingleDigit
      val nn = n * 10 + maxSingleDigit
      val newMaxDouble = {
        if (maxDoubleDigit == 0) n
        else if (nn > maxDoubleDigit) nn
        else maxDoubleDigit
      }

      (newMaxDouble, newMaxSingle)
    })
    .map { case (nn, n) => nn }
    .sum

  def part2(input: String): Long = 0

  val answer1 = part1(input)
  val answer2 = part2(input)

  println(s"Solution to part 1 is $answer1")
  println(s"Solution to part 2 is $answer2")
