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
    cloudflareQuery.jvm,
    cloudflareQuery.js,
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

lazy val cloudflareQuery = (crossProject(JSPlatform, JVMPlatform) in file("cloudflare-query"))
  .settings(commonSettings)
  .settings(
    name := "query",
    libraryDependencies ++= Seq(
      "org.http4s" %%% "http4s-core" % http4sVersion,
      "com.peknight" %%% "codec-core" % pekCodecVersion,
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
  .dependsOn(cloudflareCore)
  .settings(commonSettings)
  .settings(
    name := "circe-instances",
    libraryDependencies ++= Seq(
      "com.peknight" %%% "codec-circe" % pekCodecVersion,
      "com.peknight" %%% "commons-string" % pekCommonsVersion,
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
      "com.comcast" %%% "ip4s-core" % ip4sCoreVersion,
    ),
  )

lazy val cloudflareZoneInstances = (project in file("cloudflare-zone/instances"))
  .aggregate(
    cloudflareZoneCirceInstances.jvm,
    cloudflareZoneCirceInstances.js,
    cloudflareZoneHttp4sInstances.jvm,
    cloudflareZoneHttp4sInstances.js,
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
    cloudflareCirceInstances,
  )
  .settings(commonSettings)
  .settings(
    name := "zone-circe-instances",
    libraryDependencies ++= Seq(
      "com.peknight" %%% "circe-instances-ip4s" % pekCirceInstancesVersion,
      "io.circe" %%% "circe-parser" % circeVersion % Test,
      "io.circe" %%% "circe-jawn" % circeVersion % Test,
      "org.scalatest" %%% "scalatest" % scalaTestVersion % Test,
    ),
  )

lazy val cloudflareZoneHttp4sInstances = (crossProject(JSPlatform, JVMPlatform) in file("cloudflare-zone/instances/http4s-instances"))
  .dependsOn(cloudflareZoneCore)
  .settings(commonSettings)
  .settings(
    name := "zone-http4s-instances",
    libraryDependencies ++= Seq(
      "org.http4s" %%% "http4s-core" % http4sVersion,
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
    cloudflareZoneApi,
    cloudflareHttp4s,
    cloudflareCirceInstances,
    cloudflareZoneCirceInstances,
    cloudflareTest % Test,
  )
  .settings(commonSettings)
  .settings(
    name := "zone-http4s",
    libraryDependencies ++= Seq(
      "org.http4s" %%% "http4s-client" % http4sVersion,
      "org.http4s" %%% "http4s-circe" % http4sVersion,
      "org.http4s" %%% "http4s-ember-client" % http4sVersion % Test,
      "org.typelevel" %%% "cats-effect-testing-scalatest" % catsEffectTestingScalaTestVersion % Test,
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
    cloudflareDnsRecordInstances,
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
  .dependsOn(cloudflareZoneCore)
  .settings(commonSettings)
  .settings(
    name := "dns-record-core",
    libraryDependencies ++= Seq(
    ),
  )

lazy val cloudflareDnsRecordInstances = (project in file("cloudflare-dns/record/instances"))
  .aggregate(
    cloudflareDnsRecordCirceInstances.jvm,
    cloudflareDnsRecordCirceInstances.js,
  )
  .settings(commonSettings)
  .settings(
    name := "zone-instances",
    libraryDependencies ++= Seq(
    ),
  )

lazy val cloudflareDnsRecordCirceInstances = (crossProject(JSPlatform, JVMPlatform) in file("cloudflare-dns/record/instances/circe-instances"))
  .dependsOn(
    cloudflareDnsRecordCore,
    cloudflareCirceInstances,
    cloudflareZoneCirceInstances,
  )
  .settings(commonSettings)
  .settings(
    name := "dns-record-circe-instances",
    libraryDependencies ++= Seq(
      "io.circe" %%% "circe-parser" % circeVersion % Test,
      "io.circe" %%% "circe-jawn" % circeVersion % Test,
      "org.scalatest" %%% "scalatest" % scalaTestVersion % Test,
    ),
  )

lazy val cloudflareDnsRecordApi = (crossProject(JSPlatform, JVMPlatform) in file("cloudflare-dns/record/api"))
  .dependsOn(
    cloudflareCore,
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
    cloudflareHttp4s,
    cloudflareCirceInstances,
    cloudflareDnsRecordCirceInstances,
    cloudflareZoneHttp4sInstances,
    cloudflareTest % Test,
  )
  .settings(commonSettings)
  .settings(
    name := "dns-record-http4s",
    libraryDependencies ++= Seq(
      "org.http4s" %%% "http4s-client" % http4sVersion,
      "org.http4s" %%% "http4s-circe" % http4sVersion,
      "org.http4s" %%% "http4s-ember-client" % http4sVersion % Test,
      "org.typelevel" %%% "cats-effect-testing-scalatest" % catsEffectTestingScalaTestVersion % Test,
    ),
  )
  .jvmSettings(
    libraryDependencies ++= Seq(
      logbackClassic % Runtime,
    ),
  )

lazy val cloudflareTest = (crossProject(JSPlatform, JVMPlatform) in file("cloudflare-test"))
  .dependsOn(
    cloudflareCore,
    cloudflareZoneCore
  )
  .settings(commonSettings)
  .settings(
    name := "test",
    libraryDependencies ++= Seq(
    ),
  )

val circeVersion = "0.14.6"
val http4sVersion = "1.0.0-M34"
val ip4sCoreVersion = "3.3.0"
val scalaTestVersion = "3.2.16"
val catsEffectTestingScalaTestVersion = "1.5.0"
val logbackVersion = "1.4.11"

val pekVersion = "0.1.0-SNAPSHOT"
val pekCodecVersion = pekVersion
val pekCommonsVersion = pekVersion
val pekCirceInstancesVersion = pekVersion

val logbackClassic = "ch.qos.logback" % "logback-classic" % logbackVersion
