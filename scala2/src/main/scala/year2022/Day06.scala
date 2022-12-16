package year2022

import scala.io.Source

object Day06 extends App {

  def input: List[String] = Source.fromResource("year2022/day06.txt").getLines().toList

  println(s"Solution for part1 is: $part1")
  println(s"Solution for part1 is: $part2")

  def part1: Int = indexOfDistinctSliceOfLength(input.head, 4)
  def part2: Int = indexOfDistinctSliceOfLength(input.head, 14)

  def indexOfDistinctSliceOfLength(input: String, length: Int): Int =
    input
      .sliding(length, 1)
      .find(_.distinct.length == length)
      .map(slice => input.indexOfSlice(slice) + length)
      .getOrElse(-1)
}
