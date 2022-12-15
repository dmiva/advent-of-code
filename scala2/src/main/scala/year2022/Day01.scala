package year2022

import scala.io.Source

object Day01 extends App {

  def input: List[String] = Source.fromResource("year2022/day01.txt").getLines().toList

  println(s"Solution for part1 is: $part1")
  println(s"Solution for part2 is: $part2")

  def part1: Int = calories(input).max
  def part2: Int = calories(input).sortWith(_ > _).take(3).sum

  def calories(lines: List[String]): List[Int] =
    lines.foldRight[List[Int]](List.empty) { (line, acc) =>
      line.toIntOption
        .map { i =>
          acc.headOption.map(_ + i).getOrElse(i) :: acc.drop(1)
        }
        .getOrElse(0 :: acc)
    }
}
