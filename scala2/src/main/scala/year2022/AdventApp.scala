package year2022

trait AdventApp extends App {
  def input: List[String]
  def part1: Int
  def part2: Int

  def printResult(): Unit = {
    println(s"Solution for part1 is: $part1")
    println(s"Solution for part2 is: $part2")
  }
}
