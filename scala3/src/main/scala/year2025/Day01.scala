package year2025

import scala.io.Source

object Day01:
  private val input = Source.fromResource("aoc2025/day01.txt").mkString

  @main
  def part1(): Unit =
    val answer = part1(input)
    println(s"Solution is $answer") // 1097

  @main
  def part2(): Unit =
    val answer = part2(input)
    println(s"Solution is $answer") // 7101

  def part1(input: String): Int = input
    .linesIterator
    .foldLeft((50, 0)) { case ((before, timesZero), elem) =>
      val delta = elem match
        case s"R$n" => n.toInt
        case s"L$n" => -n.toInt
      val after = before + (delta % 100)
      val result = if (after < 0) after + 100 else if (after >= 100) after - 100 else after
      val atZero = if (after % 100 == 0) 1 else 0
      (result, timesZero + atZero)
    }
    ._2

  def part2(input: String): Int = input
    .linesIterator
    .foldLeft((50, 0)) { case ((before, timesZero), elem) =>
      val delta = elem match
        case s"R$n" => n.toInt
        case s"L$n" => -n.toInt
      val after = before + (delta % 100)
      val result = if (after < 0) after + 100 else if (after >= 100) after - 100 else after
      val atZero = if (result % 100 == 0) 1 else 0
      val rotations = Math.abs(delta / 100)
      val zeroCrossings = if (after < 0 && before > 0 || after > 100 && before > 0) 1 else 0
      (result, timesZero + atZero + rotations + zeroCrossings)
    }
    ._2
