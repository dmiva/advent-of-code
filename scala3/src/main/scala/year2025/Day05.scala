package year2025

import scala.io.Source

object Day05 extends App:
  private val N: Int = 5
  private val input: String = Source.fromResource(f"2025/day$N%02d.txt").mkString

  def part1(input: String) = processPart1(input)
  def part2(input: String) = processPart2(input)

  println(s"Solution to Day $N part 1 is ${part1(input)}")
  println(s"Solution to Day $N part 2 is ${part2(input)}")

  /////////////////////////////////////////////////////////////////////////////

  def processPart1(input: String) = {
    val ingredients = input.linesIterator.dropWhile(_.nonEmpty).drop(1).map(_.toLong).toList

    ingredients.foldLeft(0) { (count, ingredient) =>
      if (getRanges(input).exists(_.contains(ingredient))) count + 1 else count
    }
  }

  def processPart2(input: String) = mergeRanges(getRanges(input).toVector).map(_.range).sum

  def getRanges(input: String): Iterator[Range] = input.linesIterator.takeWhile(_.nonEmpty).map {
    case s"$from-$to" => Range(from.toLong, to.toLong)
  }

  def mergeRanges(ranges: Vector[Range]): Vector[Range] =
    ranges
      .sortBy(_.from)
      .foldLeft(Vector.empty[Range]) { case (acc, range) =>
        acc
          .lastOption
          .map(_.merge(range).fold(acc :+ range) { mergedRange => acc.dropRight(1) :+ mergedRange })
          .getOrElse(acc :+ range) // only on 1st step
    }

  final case class Range(from: Long, to: Long) {
    def range: Long = to - from + 1
    def contains(i: Long): Boolean = i >= from && i <= to
    // Returns Some if ranges were merged
    def merge(other: Range): Option[Range] =
      if (other.from >= from && other.to <= to) Some(Range(from, to))
      else if (other.from < from && other.to > to) Some(Range(other.from, other.to))
      else if (other.from > to) None
      else if (other.to < from) None
      else if (other.from <= to) Some(Range(from, other.to))
      else Some(Range(other.from, to))
  }
