package year2025

import scala.annotation.tailrec
import scala.io.Source

object Day03 extends App:
  private val input = Source.fromResource("2025/day03.txt").mkString

  def part1(input: String) = input.linesIterator.map(process(_, 2)).toList.sum

  def part2(input: String) = input.linesIterator.map(process(_, 12)).toList.sum

  def process(s: String, n: Int): Long =
    listOfIntsToNumber(loop(s.map(_.asDigit).toList, 0, s.length - n, n, List.empty))

  @tailrec
  def loop(list: List[Int], left: Int, right: Int, n: Int, numbers: List[Int]): List[Int] = {
    if (n > 0) {
      val sublist = list.slice(left, right + 1)
      val leftIndexOfMax = sublist.indexOf(sublist.max)
      loop(list, leftIndexOfMax + left + 1, list.length - n + 1, n - 1, sublist(leftIndexOfMax) :: numbers)
    } else numbers.reverse
  }

  def listOfIntsToNumber(list: List[Int]): Long = list.map(_.toString).mkString.toLong

  val answer1 = part1(input)
  val answer2 = part2(input)

  println(s"Solution to part 1 is $answer1")
  println(s"Solution to part 2 is $answer2")
