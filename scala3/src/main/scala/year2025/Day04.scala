package year2025

import scala.annotation.tailrec
import scala.io.Source

object Day04 extends App:
  private val input = Source.fromResource("2025/day04.txt").mkString

  def part1(input: String) = accessibleRolls(buildGrid(input))

  def part2(input: String) = loop(buildGrid(input), 0)

  def buildGrid(s: String): Map[Pos, Boolean] =
    s.linesIterator.zipWithIndex.foldLeft(Map.empty[Pos, Boolean]) { case (grid, (row, x)) =>
      grid ++ row.zipWithIndex.foldLeft(grid) { case (grid, (char, y)) =>
        if (char == '@') grid.updated(Pos(x, y), true) else grid
      }
    }

  def accessibleRolls(grid: Map[Pos, Boolean]): Int =
    grid.count { case (pos, _) => pos.neighbors.count(p => grid.contains(p)) < 4 }

  def removableRolls(grid: Map[Pos, Boolean]): Iterable[Pos] =
    grid.collect { case (pos, _) if pos.neighbors.count(p => grid.contains(p)) < 4 => pos }

  @tailrec
  def loop(grid: Map[Pos, Boolean], removed: Int): Int =
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
