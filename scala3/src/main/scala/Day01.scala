import scala.io.Source

object Day01:
  private val input = Source.fromResource("day01.txt").getLines()

  @main
  def main(): Unit =
    println(s"Part1: $part1")

  def part1: Int = input
    .scanLeft(50) { case (acc, elem) => elem match
      case s"R$plus" => acc + plus.toInt
      case s"L$minus" => acc - minus.toInt
    }.count(_ % 100 == 0)