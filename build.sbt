import Dependencies._

ThisBuild / scalaVersion := "2.12.0"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "tropical",
    libraryDependencies ++= Seq(
      "org.scalanlp" %% "breeze" % "0.13.2",
      "org.scalanlp" %% "breeze-natives" % "0.13.2",
      "org.scalanlp" %% "breeze-viz" % "0.13.2",
      "org.typelevel" %% "cats-core" % "2.0.0-M4",
      "org.scalatest" %% "scalatest" % "3.0.5" % "test",

    )
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.

resolvers += "Sonatype Releases" at "https://oss.sonatype.org/content/repositories/releases/"