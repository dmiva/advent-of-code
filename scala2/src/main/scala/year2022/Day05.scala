package year2022

import scala.io.Source

object Day05 extends App {

  def input: List[String] = Source.fromResource("year2022/day05.txt").getLines().toList
//  def input: List[String] =
//    List(
//      "    [D]",
//      "[N] [C]",
//      "[Z] [M] [P]",
//      " 1   2   3",
//      "",
//      "move 1 from 2 to 1",
//      "move 3 from 1 to 3",
//      "move 2 from 2 to 1",
//      "move 1 from 1 to 2"
//    )

  println(s"Solution for part1 is: $part1")
  println(s"Solution for part1 is: $part2")

  def part1: String = moveStacks(oneByOne = true)
  def part2: String = moveStacks(oneByOne = false)

  def moveStacks(oneByOne: Boolean): String = {
    def move(chars: Vector[Char]): Vector[Char] = if (oneByOne) chars.reverse else chars

    actions.foldLeft(stacks) {
      case (stacks, s"move $n from $from to $to") =>
        stacks
          .updated(to, move(stacks(from).take(n.toInt)) ++ stacks(to))
          .updated(from, stacks(from).drop(n.toInt))
    }
      .toList
      .sortBy { case (str, _) => str }
      .flatMap { case (_, chars) => chars.take(1) }
      .mkString
  }

  def actions: List[String] = input.dropWhile(_.nonEmpty).drop(1)

  // this is unbelievable shit
  def stacks: Map[String, Vector[Char]] =
    input
      .map(_.tail)
      .takeWhile(_.take(1).toIntOption.isEmpty)
      .reverse
      .map { s => (s, s.length) }
      .scanLeft[(String, Int)](("", 0)) { (acc, a) =>
        val (_, maxLength) = acc
        val (line, length) = a

        if (length > maxLength) (line, length)
        else (line, maxLength)
      }
      .tail
      .map { case (str, i) => str.padTo(i, ' ') }
      .map(_.grouped(4).map(_.head).toList)
      .map(_.map {
        case ' ' => None
        case c   => Some(c)
      })
      .transpose
      .map(_.flatten.reverse)
      .map(Vector.from)
      .zipWithIndex
      .map { case (chars, i) => (i + 1).toString -> chars }
      .toMap
}
