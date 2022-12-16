package year2022

import scala.io.Source
import scala.util.{Failure, Success, Try}

object Day04 extends App {

  def input: List[String] = Source.fromResource("year2022/day04.txt").getLines().toList

  println(s"Solution for part1 is: $part1")
  println(s"Solution for part1 is: $part2")

  def part1: Int = ranges(input)((list1, list2) => list1.containsSlice(list2) || list2.containsSlice(list1))
  def part2: Int = ranges(input)((list1, list2) => list1.diff(list2).length < list1.length)

  def ranges(input: List[String])(f: (List[Int], List[Int]) => Boolean): Int =
    input.map {
      case s"$a-$b,$c-$d" =>
        val list1 = List.range(a.toInt, b.toInt + 1)
        val list2 = List.range(c.toInt, d.toInt + 1)
        f(list1, list2)
    }.count(_ == true)
}
