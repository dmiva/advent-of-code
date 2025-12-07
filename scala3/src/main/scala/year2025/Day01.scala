package year2025

import scala.io.Source
import scala.util.Try

object Day01 extends App:
  private val N: Int = 1
  private val input: String = Try(Source.fromResource(f"2025/day$N%02d.txt").mkString).toOption.getOrElse("")

  def part1(input: String) = processPart1(input)
  def part2(input: String) = processPart2(input)

  println(s"Solution to Day $N part 1 is ${part1(input)}")
  println(s"Solution to Day $N part 2 is ${part2(input)}")

  /////////////////////////////////////////////////////////////////////////////
  
  def processPart1(input: String): Int = input
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

  def processPart2(input: String): Int = input
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
