package year2025

import scala.io.Source

object Day06 extends App:
  private val N: Int = 6
  private val input: String = Source.fromResource(f"2025/day$N%02d.txt").mkString

  def part1(input: String) = processPart1(input)
  def part2(input: String) = processPart2(input)

  println(s"Solution to Day $N part 1 is ${part1(input)}")
  println(s"Solution to Day $N part 2 is ${part2(input)}")

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

  def processPart2(input: String) =
    input
      .linesIterator
      .toList
      .transpose
      .map(_.mkString.trim)
      .foldLeft(List.empty[List[String]]) { (lists, b) =>
        if (b.nonEmpty)
            lists match {
              case Nil          => List(List(b))
              case head :: tail => List(b :: head) ::: tail
            }
        else List(Nil) ::: lists
      }
      .map(_.reverse)
      .map {
        case s"$number*" :: numbers => (number.trim :: numbers).map(_.toLong).product
        case s"$number+" :: numbers => (number.trim :: numbers).map(_.toLong).sum
        case _ => 0
      }
      .sum
