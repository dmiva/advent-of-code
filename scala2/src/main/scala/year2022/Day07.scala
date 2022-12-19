package year2022

import year2022.Day07.FileSystem.{Dir, File}
import scala.io.Source

object Day07 extends App {

  def input: List[String] = Source.fromResource("year2022/day07.txt").getLines().toList

  println(s"Solution for part1 is: $part1")
  println(s"Solution for part2 is: $part2")

  def part1: Int = FileTree.buildTree(input).countDirSizes.valuesIterator.filter(_ <= 100000).sum

  def part2: Int = {
    val dirSizes     = FileTree.buildTree(input).countDirSizes.valuesIterator.toList.sorted
    val limit        = 70_000_000
    val need         = 30_000_000
    val used         = dirSizes.max
    val needToDelete = need - (limit - used)

    dirSizes.filter(_ >= needToDelete).min
  }

  final case class FileTree(path: Path, dir: FileSystem.Dir) {

    def countDirSizes: Map[String, Int] = {
      import FileTree.MapOps

      def loop(
        fs: FileSystem,
        path: Path,
        dirSizes: Map[String, Int]
      ): Map[String, Int] =
        fs match {
          case File(size, _)          =>
            val paths = path.value.inits.toList.map(_.mkString(".")).filter(_.nonEmpty)
            paths.map(path => Map(path -> size)).reduce(_ |+| _)

          case Dir(dirName, children) =>
            dirSizes |+| children.values
              .map { child => loop(child, path.append(dirName), Map.empty) }
              .reduceOption(_ |+| _)
              .getOrElse(dirSizes)
        }

      loop(dir, Path.Empty, Map.empty)
    }

    def setAction(action: Action): FileTree = FileTree(path.performAction(action), dir)

    def addFileOrDir(file: FileSystem): FileTree = {

      def loop(
        path: Path,
        fileToAdd: FileSystem,
        dir: FileSystem.Dir
      ): FileSystem.Dir =
        path.next.value match {
          case Nil    => dir.copy(children = dir.children.updated(fileToAdd.name, fileToAdd))
          case x :: _ =>
            dir.children
              .get(x)
              .map {
                case _: File       => dir // impossible
                case childDir: Dir =>
                  val subdir = loop(path.next, fileToAdd, childDir)
                  dir.copy(children = dir.children.updated(subdir.name, subdir))
              }
              .getOrElse(dir)
        }

      val updatedFileSystem = loop(path, file, dir)
      FileTree(path, updatedFileSystem)
    }
  }

  object FileTree {
    private val Empty: FileTree = FileTree(Path.Empty, Dir("/", Map()))

    def buildTree(lines: List[String]): FileTree =
      lines.foldLeft(FileTree.Empty) { (fileTree, line) =>
        line match {
          case s"$$ $action" => fileTree.setAction(Action.from(action))
          case fileOrDir     => fileTree.addFileOrDir(FileSystem.from(fileOrDir))
        }
      }

    implicit class MapOps[K, V](val map: Map[K, V]) extends AnyVal {
      def |+|(that: Map[K, V])(implicit N: Numeric[V]): Map[K, V] = {
        val mergedList = map.toList ++ that.toList
        mergedList.groupBy(_._1).map { case (k, value) => k -> value.map(_._2).sum }
      }
    }
  }

  final case class Path(value: List[String]) {
    def performAction(action: Action): Path =
      action match {
        case Action.OpenDir(name) => append(name)
        case Action.List          => Path(value)
        case Action.GoHome        => Path(List("/"))
        case Action.GoBack        => Path(value.dropRight(1))
      }

    def append(name: String): Path = Path(value :+ name)
    def next: Path                 = Path(value.drop(1))
  }

  object Path {
    val Empty: Path = Path(List.empty)
  }

  sealed trait Action
  object Action {
    def from(str: String): Action =
      str match {
        case "cd /"      => Action.GoHome
        case "cd .."     => Action.GoBack
        case s"cd $name" => Action.OpenDir(name)
        case "ls"        => Action.List
      }

    final case class OpenDir(name: String) extends Action
    case object List                       extends Action
    case object GoHome                     extends Action
    case object GoBack                     extends Action
  }

  sealed trait FileSystem {
    val name: String
  }
  object FileSystem       {
    def from(s: String): FileSystem =
      s match {
        case s"dir $name"                           => Dir(name, Map.empty)
        case s"$len $name" if len.forall(_.isDigit) => File(len.toInt, name)
      }

    final case class File(size: Int, name: String)                        extends FileSystem
    final case class Dir(name: String, children: Map[String, FileSystem]) extends FileSystem
  }
}
