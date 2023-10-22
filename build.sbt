ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.1"

ThisBuild / organization := "com.peknight"

lazy val commonSettings = Seq(
  scalacOptions ++= Seq(
    "-feature",
    "-deprecation",
    "-unchecked",
    "-Xfatal-warnings",
    "-language:strictEquality",
    "-Xmax-inlines:64"
  ),
)

lazy val cloudflare = (project in file("."))
  .aggregate(
    cloudflareApi.jvm,
    cloudflareApi.js,
  )
  .settings(commonSettings)
  .settings(
    name := "cloudflare",
  )

lazy val cloudflareApi = (crossProject(JSPlatform, JVMPlatform) in file("cloudflare-api"))
  .settings(commonSettings)
  .settings(
    name := "cloudflare-api",
    libraryDependencies ++= Seq(
    ),
  )
