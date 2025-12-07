package year2025

import scala.io.Source
import scala.util.Try

object Day03 extends App:
  private val N: Int = 3
  private val input: String = Try(Source.fromResource(f"2025/day$N%02d.txt").mkString).toOption.getOrElse("")

  def part1(input: String) = processPart1(input)
  def part2(input: String) = processPart2(input)

  println(s"Solution to Day $N part 1 is ${part1(input)}")
  println(s"Solution to Day $N part 2 is ${part2(input)}")

  /////////////////////////////////////////////////////////////////////////////

  def processPart1(input: String) = input.linesIterator.map(process(_, 2)).toList.sum

  def processPart2(input: String) = input.linesIterator.map(process(_, 12)).toList.sum

  def process(s: String, n: Int): Long =
    listOfIntsToNumber(loop(s.map(_.asDigit).toList, 0, s.length - n, n, List.empty))

  @scala.annotation.tailrec
  def loop(list: List[Int], left: Int, right: Int, n: Int, numbers: List[Int]): List[Int] = {
    if (n > 0) {
      val sublist = list.slice(left, right + 1)
      val leftIndexOfMax = sublist.indexOf(sublist.max)
      loop(list, leftIndexOfMax + left + 1, list.length - n + 1, n - 1, sublist(leftIndexOfMax) :: numbers)
    } else numbers.reverse
  }

  def listOfIntsToNumber(list: List[Int]): Long = list.map(_.toString).mkString.toLong
