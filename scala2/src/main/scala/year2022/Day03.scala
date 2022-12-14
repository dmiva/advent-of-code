package year2022

import scala.io.Source
import scala.language.implicitConversions

object Day03 extends App {

  val input = Source.fromResource("year2022/day03.txt").getLines()

  println(s"Solution for part1 is: ${part1(input)}")

  def part1(lines: Iterator[String]): Int =
    lines.flatMap { line =>
      val (a, b) = line.splitAt(line.length / 2)
      (a intersect b).take(1).map(toPriority)
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
