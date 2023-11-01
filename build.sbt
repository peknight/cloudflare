ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.1"

ThisBuild / organization := "com.peknight.cloudflare"

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
    cloudflareCore.jvm,
    cloudflareCore.js,
    cloudflareHttp4s.jvm,
    cloudflareHttp4s.js,
    cloudflareInstances,
    cloudflareZone,
    cloudflareDns,
    cloudflareTest.jvm,
    cloudflareTest.js,
  )
  .settings(commonSettings)
  .settings(
    name := "cloudflare",
  )

lazy val cloudflareCore = (crossProject(JSPlatform, JVMPlatform) in file("cloudflare-core"))
  .settings(commonSettings)
  .settings(
    name := "core",
    libraryDependencies ++= Seq(
    ),
  )

lazy val cloudflareHttp4s = (crossProject(JSPlatform, JVMPlatform) in file("cloudflare-http4s"))
  .dependsOn(cloudflareCore)
  .settings(commonSettings)
  .settings(
    name := "http4s",
    libraryDependencies ++= Seq(
      "org.http4s" %%% "http4s-core" % http4sVersion,
    ),
  )

lazy val cloudflareInstances = (project in file("cloudflare-instances"))
  .aggregate(
    cloudflareCirceInstances.jvm,
    cloudflareCirceInstances.js,
  )
  .settings(commonSettings)
  .settings(
    name := "instances",
    libraryDependencies ++= Seq(
    ),
  )

lazy val cloudflareCirceInstances = (crossProject(JSPlatform, JVMPlatform) in file("cloudflare-instances/circe-instances"))
  .settings(commonSettings)
  .settings(
    name := "circe-instances",
    libraryDependencies ++= Seq(
      "io.circe" %%% "circe-core" % circeVersion,

    ),
  )

lazy val cloudflareZone = (project in file("cloudflare-zone"))
  .aggregate(
    cloudflareZoneCore.jvm,
    cloudflareZoneCore.js,
    cloudflareZoneInstances,
    cloudflareZoneApi.jvm,
    cloudflareZoneApi.js,
    cloudflareZoneHttp4s.jvm,
    cloudflareZoneHttp4s.js,
  )
  .settings(commonSettings)
  .settings(
    name := "zone",
    libraryDependencies ++= Seq(
    ),
  )

lazy val cloudflareZoneCore = (crossProject(JSPlatform, JVMPlatform) in file("cloudflare-zone/core"))
  .settings(commonSettings)
  .settings(
    name := "zone-core",
    libraryDependencies ++= Seq(
    ),
  )

lazy val cloudflareZoneInstances = (project in file("cloudflare-zone/instances"))
  .aggregate(
    cloudflareZoneCirceInstances.jvm,
    cloudflareZoneCirceInstances.js,
  )
  .settings(commonSettings)
  .settings(
    name := "zone-instances",
    libraryDependencies ++= Seq(
    ),
  )

lazy val cloudflareZoneCirceInstances = (crossProject(JSPlatform, JVMPlatform) in file("cloudflare-zone/instances/circe-instances"))
  .dependsOn(
    cloudflareZoneCore,
    cloudflareCore % Test,
    cloudflareCirceInstances % Test,
  )
  .settings(commonSettings)
  .settings(
    name := "zone-circe-instances",
    libraryDependencies ++= Seq(
      "io.circe" %%% "circe-core" % circeVersion,
      "io.circe" %%% "circe-parser" % circeVersion % Test,
      "io.circe" %%% "circe-jawn" % circeVersion % Test,
      "com.peknight" %%% "generic-circe" % pekGenericVersion % Test,
      "org.scalatest" %%% "scalatest" % scalaTestVersion % Test,
    ),
  )

lazy val cloudflareZoneApi = (crossProject(JSPlatform, JVMPlatform) in file("cloudflare-zone/api"))
  .dependsOn(
    cloudflareCore,
    cloudflareZoneCore,
  )
  .settings(commonSettings)
  .settings(
    name := "zone-api",
    libraryDependencies ++= Seq(
    ),
  )

lazy val cloudflareZoneHttp4s = (crossProject(JSPlatform, JVMPlatform) in file("cloudflare-zone/http4s"))
  .dependsOn(
    cloudflareCirceInstances,
    cloudflareHttp4s,
    cloudflareZoneCirceInstances,
    cloudflareZoneApi,
    cloudflareTest % Test,
  )
  .settings(commonSettings)
  .settings(
    name := "zone-http4s",
    libraryDependencies ++= Seq(
      "org.http4s" %%% "http4s-client" % http4sVersion,
      "org.http4s" %%% "http4s-circe" % http4sVersion,
      "com.peknight" %%% "generic-circe" % pekGenericVersion,
      "org.http4s" %%% "http4s-ember-client" % http4sVersion % Test,
      "org.typelevel" %% "cats-effect-testing-scalatest" % catsEffectTestingScalaTestVersion % Test,
    ),
  )
  .jvmSettings(
    libraryDependencies ++= Seq(
      logbackClassic % Runtime,
    ),
  )

lazy val cloudflareDns = (project in file("cloudflare-dns"))
  .aggregate(
    cloudflareDnsRecord,
  )
  .settings(commonSettings)
  .settings(
    name := "dns",
  )

lazy val cloudflareDnsRecord = (project in file("cloudflare-dns/record"))
  .aggregate(
    cloudflareDnsRecordCore.jvm,
    cloudflareDnsRecordCore.js,
    cloudflareDnsRecordApi.jvm,
    cloudflareDnsRecordApi.js,
    cloudflareDnsRecordHttp4s.jvm,
    cloudflareDnsRecordHttp4s.js,
  )
  .settings(commonSettings)
  .settings(
    name := "dns-record",
    libraryDependencies ++= Seq(
    ),
  )

lazy val cloudflareDnsRecordCore = (crossProject(JSPlatform, JVMPlatform) in file("cloudflare-dns/record/core"))
  .settings(commonSettings)
  .settings(
    name := "dns-record-core",
    libraryDependencies ++= Seq(
    ),
  )

lazy val cloudflareDnsRecordApi = (crossProject(JSPlatform, JVMPlatform) in file("cloudflare-dns/record/api"))
  .dependsOn(
    cloudflareCore,
    cloudflareZoneCore,
    cloudflareDnsRecordCore,
  )
  .settings(commonSettings)
  .settings(
    name := "dns-record-api",
    libraryDependencies ++= Seq(
    ),
  )

lazy val cloudflareDnsRecordHttp4s = (crossProject(JSPlatform, JVMPlatform) in file("cloudflare-dns/record/http4s"))
  .dependsOn(
    cloudflareDnsRecordApi,
  )
  .settings(commonSettings)
  .settings(
    name := "dns-record-http4s",
    libraryDependencies ++= Seq(
    ),
  )

lazy val cloudflareTest = (crossProject(JSPlatform, JVMPlatform) in file("cloudflare-test"))
  .dependsOn(cloudflareCore)
  .settings(commonSettings)
  .settings(
    name := "test",
    libraryDependencies ++= Seq(
    ),
  )

val circeVersion = "0.14.6"
val http4sVersion = "1.0.0-M34"
val scalaTestVersion = "3.2.16"
val catsEffectTestingScalaTestVersion = "1.5.0"
val logbackVersion = "1.4.11"

val pekVersion = "0.1.0-SNAPSHOT"
val pekGenericVersion = pekVersion

val logbackClassic = "ch.qos.logback" % "logback-classic" % logbackVersion
