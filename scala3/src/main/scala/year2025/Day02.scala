package year2025

import scala.io.Source
import scala.util.Try

object Day02 extends App:
  private val N: Int = 2
  private val input: String = Try(Source.fromResource(f"2025/day$N%02d.txt").mkString).toOption.getOrElse("")

  def part1(input: String) = processPart1(input)
  def part2(input: String) = processPart2(input)

  println(s"Solution to Day $N part 1 is ${part1(input)}")
  println(s"Solution to Day $N part 2 is ${part2(input)}")

  /////////////////////////////////////////////////////////////////////////////

  def processPart1(input: String): Long =
    input
      .split(",").map {
        case s"$low-$high" =>
          (low.toLong to high.toLong).map { i =>
            val iStr = i.toString
            val (strLow, strHigh) = iStr.splitAt(iStr.length / 2)
            if (strLow == strHigh) i else 0
          }.sum
      }.sum

  def processPart2(input: String): Long =
    input
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
