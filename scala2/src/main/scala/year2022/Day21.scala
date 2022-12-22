package year2022

import scala.io.Source

object Day21 extends App {

  def input: List[String] = Source.fromResource("year2022/day21.txt").getLines().toList

  println(s"Solution for part1 is: $part1")

  def part1: Long = {

    def parseAction(action: String): (Long, Long) => Long = action match {
      case "+" => _ + _
      case "-" => _ - _
      case "/" => _ / _
      case "*" => _ * _
    }

    val monkeys: Map[String, Monkey] = input.map {
      case s"$name: $monkey1 $action $monkey2" => MonkeyAction(name, math = MathAction(monkey1, parseAction(action), monkey2))
      case s"$name: $number" => MonkeyNumber(name, number.toInt)
    }.map(monkey => monkey.name -> monkey).toMap

    def evalMonkeys(input: Map[String, Monkey]): Long = {

      def loop(monkey: Option[Monkey]): Long = {
        monkey match {
          case Some(monkey: MonkeyAction) =>
            val m1 = input.get(monkey.math.monkey1)
            val m2 = input.get(monkey.math.monkey2)
            monkey.math.action(loop(m1), loop(m2))

          case Some(monkey: MonkeyNumber) => monkey.value
          case None                       => 0
        }
      }

      loop(input.get("root"))
    }

    evalMonkeys(monkeys)
  }

  sealed trait Monkey {
    val name: String
  }

  final case class MonkeyNumber(name: String, value: Long) extends Monkey
  final case class MonkeyAction(name: String, math: MathAction) extends Monkey
  final case class MathAction(monkey1: String, action: (Long, Long) => Long, monkey2: String)
}
