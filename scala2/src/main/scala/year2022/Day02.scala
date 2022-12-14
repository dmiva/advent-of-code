package year2022

import scala.io.Source

object Day02 extends App {

  val input = Source.fromResource("year2022/day02.txt").getLines()

  println(s"Solution for part1 is: $part1")
  println(s"Solution for part2 is: $part2")

  def part1: Int = {
    val results = for {
      game <- input
      raw  <- RawInput.from(game)
      c1   <- Combination.from(raw.a)
      c2   <- Combination.from(raw.b)
    } yield Game(c1, c2).score

    results.sum
  }

  def part2: Int = {
    val results = for {
      game <- input
      raw  <- RawInput.from(game)
      c1   <- Combination.from(raw.a)
      o    <- GameOutcome.from(raw.b)
      c2   <- Combination.Values.find(c => c.against(c1) == o)
    } yield Game(c1, c2).score

    results.sum
  }

  final case class RawInput(a: String, b: String)

  object RawInput {
    def from(s: String): Option[RawInput] =
      s.split(" ").toList match {
        case a :: b :: Nil => Some(RawInput(a, b))
        case _             => None
      }
  }

  final case class Game(a: Combination, b: Combination) {
    val score: Int = b.against(a).score + b.score
  }

  sealed trait Score {
    val score: Int
  }
  sealed trait GameOutcome extends Score {
    val score: Int
  }

  object GameOutcome {

    def from(s: String): Option[GameOutcome] =
      s match {
        case "X" => Some(GameOutcome.Loss)
        case "Y" => Some(GameOutcome.Draw)
        case "Z" => Some(GameOutcome.Win)
        case _   => None
      }
    case object Win extends GameOutcome { val score = 6 }
    case object Draw extends GameOutcome { val score = 3 }
    case object Loss extends GameOutcome { val score = 0 }
  }

  sealed trait Combination extends Score {
    val score: Int
    def against(c: Combination): GameOutcome
  }
  object Combination {

    def from(s: String): Option[Combination] =
      s match {
        case "A" | "X" => Some(Rock)
        case "B" | "Y" => Some(Paper)
        case "C" | "Z" => Some(Scissors)
        case _         => None
      }
    case object Rock extends Combination {
      val score: Int = 1

      def against(c: Combination): GameOutcome =
        c match {
          case Rock     => GameOutcome.Draw
          case Paper    => GameOutcome.Loss
          case Scissors => GameOutcome.Win
        }
    }
    case object Paper extends Combination {
      val score: Int = 2

      def against(c: Combination): GameOutcome =
        c match {
          case Paper    => GameOutcome.Draw
          case Scissors => GameOutcome.Loss
          case Rock     => GameOutcome.Win
        }
    }
    case object Scissors extends Combination {
      val score: Int = 3

      def against(c: Combination): GameOutcome =
        c match {
          case Scissors => GameOutcome.Draw
          case Rock     => GameOutcome.Loss
          case Paper    => GameOutcome.Win
        }
    }

    val Values: List[Combination] = List(Rock, Paper, Scissors)
  }
}
