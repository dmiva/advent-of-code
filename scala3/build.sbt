ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.7"

lazy val root = (project in file("."))
  .settings(
    name := "advent-of-code-scala3",
    libraryDependencies += "org.scalatest" %% "scalatest-funsuite" % "3.2.19" % Test
  )
