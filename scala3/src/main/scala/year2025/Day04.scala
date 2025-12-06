package year2025

import scala.annotation.tailrec
import scala.io.Source

object Day04 extends App:
  private val input = Source.fromResource("2025/day04.txt").mkString

  def part1(input: String) = accessibleRolls(buildGrid(input))

  def part2(input: String) = loop(buildGrid(input), 0)

  def buildGrid(s: String): Set[Pos] =
    s.linesIterator.zipWithIndex.foldLeft(Set.empty[Pos]) { case (grid, (row, x)) =>
      grid ++ row.zipWithIndex.foldLeft(grid) { case (grid, (char, y)) =>
        if (char == '@') grid + Pos(x, y) else grid
      }
    }

  def accessibleRolls(grid: Set[Pos]): Int =
    grid.count { pos => pos.neighbors.count(p => grid.contains(p)) < 4 }

  def removableRolls(grid: Set[Pos]): Iterable[Pos] =
    grid.collect { case pos if pos.neighbors.count(p => grid.contains(p)) < 4 => pos }

  @tailrec
  def loop(grid: Set[Pos], removed: Int): Int =
    val toRemove = removableRolls(grid)
    if (toRemove.nonEmpty) loop(grid.removedAll(toRemove), removed + toRemove.size)
    else removed

  final case class Pos(x: Int, y: Int) {
    def neighbors: Seq[Pos] = {
      val allPos = for {
        xs <- x - 1 to x + 1
        ys <- y - 1 to y + 1
      } yield Pos(xs, ys)
      allPos.filterNot(p => p.x == x && p.y == y)
    }
  }

  val answer1 = part1(input)
  val answer2 = part2(input)

  println(s"Solution to part 1 is $answer1")
  println(s"Solution to part 2 is $answer2")
