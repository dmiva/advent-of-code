package year2022

import scala.io.Source
import scala.language.implicitConversions

object Day03 extends App {

  def input: List[String] = Source.fromResource("year2022/day03.txt").getLines().toList

  println(s"Solution for part1 is: $part1")
  println(s"Solution for part1 is: $part2")

  def part1: Int =
    input.flatMap { line =>
      val (a, b) = line.splitAt(line.length / 2)
      (a intersect b).take(1).map(toPriority)
    }.sum

  def part2: Int =
    input.sliding(3, 3).flatMap { group =>
      group.reduceLeft((a, b) => a intersect b).take(1).map(toPriority)
    }.sum

  def toPriority(c: Char): Int = {
    implicit def charToInt(c: Char): Int = c.toInt
    c match {
      case c if c >= 'a' && c <= 'z' => c - 'a' + 1
      case c if c >= 'A' && c <= 'Z' => c - 'A' + 27
      case _                         => 0
    }
  }
}
