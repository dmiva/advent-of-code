package aoc2025

import scala.io.Source

object Day02 extends App:
  private val input = Source.fromResource("aoc2025/day02.txt").mkString

  @main
  def main(): Unit =
    val answer1 = part1(input)
    println(s"Solution to part 1 is $answer1")

    val answer2 = part2(input)
    println(s"Solution to part 2 is $answer2")

  def part1(input: String): Long = input
    .split(",").map {
      case s"$low-$high" =>
        (low.toLong to high.toLong).map { i =>
          val iStr = i.toString
          val (strLow, strHigh) = iStr.splitAt(iStr.length / 2)
          if (strLow == strHigh) i else 0
        }.sum
    }.sum

  def part2(input: String): Long = input
    .split(",")
    .map {
      case s"$low-$high" =>
        (low.toLong to high.toLong).map { i =>
          val invalid = isInvalid(i)
          if (invalid) i else 0L
        }.sum
    }.sum

  def isInvalid(i: Long): Boolean =
    val iStr = i.toString
    val len = iStr.length
    (1 until iStr.length).exists { length =>
      iStr.toList.grouped(length).distinct.length == 1
    }
