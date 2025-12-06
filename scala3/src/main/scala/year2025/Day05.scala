package year2025

import scala.io.Source

object Day05 extends App:
  private val N: Int = 5
  private val input: String = Source.fromResource(f"2025/day$N%02d.txt").mkString

  def part1(input: String) = processPart1(input)
  val answer1 = part1(input)
  println(s"Solution to part 1 is $answer1")

  def part2(input: String) = processPart2(input)
  val answer2 = part2(input)
  println(s"Solution to part 2 is $answer2")

  /////////////////////////////////////////////////////////////////////////////

  def processPart1(input: String) = {
    val ranges = input.linesIterator.takeWhile(_.nonEmpty).map {
      case s"$from-$to" => Range(from.toLong, to.toLong)
    }.toList

    val ingredients = input.linesIterator.dropWhile(_.nonEmpty).drop(1).map(_.toLong).toList

    ingredients.foldLeft(0) { (count, ingredient) =>
      if (ranges.exists(_.contains(ingredient))) count + 1 else count
    }
  }

  def processPart2(input: String) = 0

  final case class Range(from: Long, to: Long) {
    def contains(i: Long): Boolean = i >= from && i <= to
  }
