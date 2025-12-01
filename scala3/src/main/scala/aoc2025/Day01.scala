package aoc2025

import scala.io.Source

object Day01:
  private val input = Source.fromResource("aoc2025/day01.txt").mkString

  @main
  def part1(): Unit =
    val answer = part1(input)
    println(s"Solution is $answer")

  def part1(input: String): Int = input.linesIterator
    .foldLeft((50, 0)) { case ((acc, times), elem) =>
      val delta = elem match
        case s"R$plus" => plus.toInt
        case s"L$minus" => -minus.toInt
      val sum = acc + delta
      (sum, times + (if (sum % 100 == 0) 1 else 0))
    }._2