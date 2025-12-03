ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.18"

lazy val root = (project in file("."))
  .settings(
    name := "advent-of-code-scala2",
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest-wordspec"       % "3.2.19" % Test,
      "org.scalatest" %% "scalatest-shouldmatchers" % "3.2.19" % Test
    )
  )
