ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.7.1"

ThisBuild / organization := "com.peknight.cloudflare"

ThisBuild / versionScheme := Some("early-semver")

ThisBuild / publishTo := {
  val nexus = "https://nexus.peknight.com/repository"
  if (isSnapshot.value)
    Some("snapshot" at s"$nexus/maven-snapshots/")
  else
    Some("releases" at s"$nexus/maven-releases/")
}

ThisBuild / credentials ++= Seq(
  Credentials(Path.userHome / ".sbt" / ".credentials")
)

ThisBuild / resolvers ++= Seq(
  "Pek Nexus" at "https://nexus.peknight.com/repository/maven-public/",
)

lazy val commonSettings = Seq(
  scalacOptions ++= Seq(
    "-feature",
    "-deprecation",
    "-unchecked",
    "-Xfatal-warnings",
    "-language:strictEquality",
    "-Xmax-inlines:64",
    "-Ximplicit-search-limit:500000",
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
    cloudflareDNS,
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
      "com.peknight" %%% "api-core" % pekApiVersion,
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
    cloudflareCodecInstances.jvm,
    cloudflareCodecInstances.js,
    cloudflareCirceInstances.jvm,
    cloudflareCirceInstances.js,
    cloudflareQueryInstances.jvm,
    cloudflareQueryInstances.js,
  )
  .settings(commonSettings)
  .settings(
    name := "instances",
    libraryDependencies ++= Seq(
    ),
  )

lazy val cloudflareCodecInstances = (crossProject(JSPlatform, JVMPlatform) in file("cloudflare-instances/codec"))
  .dependsOn(cloudflareCore)
  .settings(commonSettings)
  .settings(
    name := "codec-instances",
    libraryDependencies ++= Seq(
      "com.peknight" %%% "codec-core" % pekCodecVersion,
      "com.peknight" %%% "commons-text" % pekCommonsVersion,
    ),
  )

lazy val cloudflareCirceInstances = (crossProject(JSPlatform, JVMPlatform) in file("cloudflare-instances/circe"))
  .dependsOn(cloudflareCodecInstances)
  .settings(commonSettings)
  .settings(
    name := "circe-instances",
    libraryDependencies ++= Seq(
      "com.peknight" %%% "codec-circe" % pekCodecVersion,
    ),
  )

lazy val cloudflareQueryInstances = (crossProject(JSPlatform, JVMPlatform) in file("cloudflare-instances/query"))
  .dependsOn(cloudflareCodecInstances)
  .settings(commonSettings)
  .settings(
    name := "query-instances",
    libraryDependencies ++= Seq(
      "com.peknight" %%% "query-core" % pekQueryVersion,
    ),
  )

lazy val cloudflareZone = (project in file("cloudflare-zone"))
  .aggregate(
    cloudflareZoneCore.jvm,
    cloudflareZoneCore.js,
    cloudflareZoneConfig.jvm,
    cloudflareZoneConfig.js,
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
  .dependsOn(cloudflareCore)
  .settings(commonSettings)
  .settings(
    name := "zone-core",
    libraryDependencies ++= Seq(
      "com.comcast" %%% "ip4s-core" % ip4sCoreVersion,
    ),
  )

lazy val cloudflareZoneConfig = (crossProject(JSPlatform, JVMPlatform) in file("cloudflare-zone/config"))
  .dependsOn(cloudflareZoneCore)
  .settings(commonSettings)
  .settings(
    name := "zone-config",
    libraryDependencies ++= Seq(
      "com.peknight" %%% "auth-core" % pekAuthVersion,
    ),
  )

lazy val cloudflareZoneInstances = (project in file("cloudflare-zone/instances"))
  .aggregate(
    cloudflareZoneCodecInstances.jvm,
    cloudflareZoneCodecInstances.js,
    cloudflareZoneCirceInstances.jvm,
    cloudflareZoneCirceInstances.js,
    cloudflareZoneQueryInstances.jvm,
    cloudflareZoneQueryInstances.js,
  )
  .settings(commonSettings)
  .settings(
    name := "zone-instances",
    libraryDependencies ++= Seq(
    ),
  )

lazy val cloudflareZoneCodecInstances = (crossProject(JSPlatform, JVMPlatform) in file("cloudflare-zone/instances/codec"))
  .dependsOn(
    cloudflareZoneCore,
    cloudflareZoneConfig,
    cloudflareCodecInstances,
  )
  .settings(commonSettings)
  .settings(
    name := "zone-codec-instances",
    libraryDependencies ++= Seq(
      "com.peknight" %%% "codec-effect" % pekCodecVersion,
      "com.peknight" %%% "codec-ip4s" % pekCodecVersion,
      "com.peknight" %%% "commons-text" % pekCommonsVersion,
    ),
  )

lazy val cloudflareZoneCirceInstances = (crossProject(JSPlatform, JVMPlatform) in file("cloudflare-zone/instances/circe"))
  .dependsOn(
    cloudflareZoneCodecInstances,
    cloudflareCirceInstances % Test,
  )
  .settings(commonSettings)
  .settings(
    name := "zone-circe-instances",
    libraryDependencies ++= Seq(
      "com.peknight" %%% "codec-circe" % pekCodecVersion,
      "com.peknight" %%% "codec-circe-parser" % pekCodecVersion % Test,
      "org.scalatest" %%% "scalatest" % scalaTestVersion % Test,
    ),
  )

lazy val cloudflareZoneQueryInstances = (crossProject(JSPlatform, JVMPlatform) in file("cloudflare-zone/instances/query"))
  .dependsOn(
    cloudflareQueryInstances,
    cloudflareZoneCodecInstances,
  )
  .settings(commonSettings)
  .settings(
    name := "zone-query-instances",
    libraryDependencies ++= Seq(
      "com.peknight" %%% "query-core" % pekCodecVersion,
    ),
  )

lazy val cloudflareZoneApi = (crossProject(JSPlatform, JVMPlatform) in file("cloudflare-zone/api"))
  .dependsOn(
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
    cloudflareZoneQueryInstances,
  )
  .settings(commonSettings)
  .settings(
    name := "zone-http4s",
    libraryDependencies ++= Seq(
      "org.http4s" %%% "http4s-client" % http4sVersion,
      "com.peknight" %%% "codec-http4s-circe" % pekCodecVersion,
      "com.peknight" %%% "query-http4s" % pekQueryVersion,
      "com.peknight" %%% "auth-http4s" % pekAuthVersion,
      "org.http4s" %%% "http4s-ember-client" % http4sVersion % Test,
      "com.peknight" %%% "logging-core" % pekLoggingVersion % Test,
      "com.peknight" %%% "logback-config" % pekLoggingVersion % Test,
      "org.scalatest" %%% "scalatest-flatspec" % scalaTestVersion % Test,
      "org.typelevel" %%% "cats-effect-testing-scalatest" % catsEffectTestingScalaTestVersion % Test,
    ),
  )
  .jvmSettings(
    libraryDependencies ++= Seq(
      log4CatsSlf4j % Test,
      logbackClassic % Test,
    ),
  )

lazy val cloudflareDNS = (project in file("cloudflare-dns"))
  .aggregate(
    cloudflareDNSRecord,
  )
  .settings(commonSettings)
  .settings(
    name := "dns",
  )

lazy val cloudflareDNSRecord = (project in file("cloudflare-dns/record"))
  .aggregate(
    cloudflareDNSRecordCore.jvm,
    cloudflareDNSRecordCore.js,
    cloudflareDNSRecordInstances,
    cloudflareDNSRecordApi.jvm,
    cloudflareDNSRecordApi.js,
    cloudflareDNSRecordHttp4s.jvm,
    cloudflareDNSRecordHttp4s.js,
  )
  .settings(commonSettings)
  .settings(
    name := "dns-record",
    libraryDependencies ++= Seq(
    ),
  )

lazy val cloudflareDNSRecordCore = (crossProject(JSPlatform, JVMPlatform) in file("cloudflare-dns/record/core"))
  .dependsOn(cloudflareZoneCore)
  .settings(commonSettings)
  .settings(
    name := "dns-record-core",
    libraryDependencies ++= Seq(
    ),
  )

lazy val cloudflareDNSRecordInstances = (project in file("cloudflare-dns/record/instances"))
  .aggregate(
    cloudflareDNSRecordCodecInstances.jvm,
    cloudflareDNSRecordCodecInstances.js,
    cloudflareDNSRecordCirceInstances.jvm,
    cloudflareDNSRecordCirceInstances.js,
    cloudflareDNSRecordQueryInstances.jvm,
    cloudflareDNSRecordQueryInstances.js,
  )
  .settings(commonSettings)
  .settings(
    name := "dns-record-instances",
    libraryDependencies ++= Seq(
    ),
  )

lazy val cloudflareDNSRecordCodecInstances = (crossProject(JSPlatform, JVMPlatform) in file("cloudflare-dns/record/instances/codec"))
  .dependsOn(
    cloudflareDNSRecordCore,
    cloudflareZoneCodecInstances,
  )
  .settings(commonSettings)
  .settings(
    name := "dns-record-codec-instances",
    libraryDependencies ++= Seq(
      "com.peknight" %%% "codec-ip4s" % pekCodecVersion,
      "com.peknight" %%% "cats-instances-time" % pekInstancesVersion,
    ),
  )

lazy val cloudflareDNSRecordCirceInstances = (crossProject(JSPlatform, JVMPlatform) in file("cloudflare-dns/record/instances/circe"))
  .dependsOn(
    cloudflareDNSRecordCodecInstances,
    cloudflareCirceInstances % Test,
  )
  .settings(commonSettings)
  .settings(
    name := "dns-record-circe-instances",
    libraryDependencies ++= Seq(
      "com.peknight" %%% "codec-circe" % pekCodecVersion,
      "com.peknight" %%% "codec-circe-parser" % pekCodecVersion % Test,
      "org.scalatest" %%% "scalatest" % scalaTestVersion % Test,
    ),
  )

lazy val cloudflareDNSRecordQueryInstances = (crossProject(JSPlatform, JVMPlatform) in file("cloudflare-dns/record/instances/query"))
  .dependsOn(
    cloudflareQueryInstances,
    cloudflareDNSRecordCodecInstances,
  )
  .settings(commonSettings)
  .settings(
    name := "dns-record-query-instances",
    libraryDependencies ++= Seq(
      "com.peknight" %%% "query-core" % pekCodecVersion,
    ),
  )

lazy val cloudflareDNSRecordApi = (crossProject(JSPlatform, JVMPlatform) in file("cloudflare-dns/record/api"))
  .dependsOn(
    cloudflareDNSRecordCore,
  )
  .settings(commonSettings)
  .settings(
    name := "dns-record-api",
    libraryDependencies ++= Seq(
    ),
  )

lazy val cloudflareDNSRecordHttp4s = (crossProject(JSPlatform, JVMPlatform) in file("cloudflare-dns/record/http4s"))
  .dependsOn(
    cloudflareDNSRecordApi,
    cloudflareHttp4s,
    cloudflareCirceInstances,
    cloudflareDNSRecordCirceInstances,
    cloudflareDNSRecordQueryInstances,
  )
  .settings(commonSettings)
  .settings(
    name := "dns-record-http4s",
    libraryDependencies ++= Seq(
      "org.http4s" %%% "http4s-client" % http4sVersion,
      "com.peknight" %%% "codec-http4s" % pekCodecVersion,
      "com.peknight" %%% "codec-http4s-circe" % pekCodecVersion,
      "com.peknight" %%% "query-http4s" % pekQueryVersion,
      "com.peknight" %%% "auth-http4s" % pekAuthVersion,
      "org.http4s" %%% "http4s-ember-client" % http4sVersion % Test,
      "com.peknight" %%% "logging-core" % pekLoggingVersion % Test,
      "com.peknight" %%% "logback-config" % pekLoggingVersion % Test,
      "org.scalatest" %%% "scalatest-flatspec" % scalaTestVersion % Test,
      "org.typelevel" %%% "cats-effect-testing-scalatest" % catsEffectTestingScalaTestVersion % Test,
    ),
  )
  .jvmSettings(
    libraryDependencies ++= Seq(
      log4CatsSlf4j % Test,
      logbackClassic % Test,
    ),
  )

val circeVersion = "0.14.13"
val http4sVersion = "1.0.0-M34"
val ip4sCoreVersion = "3.7.0"
val log4CatsVersion = "2.7.1"
val scalaTestVersion = "3.2.19"
val catsEffectTestingScalaTestVersion = "1.6.0"
val logbackVersion = "1.5.18"

val pekVersion = "0.1.0-SNAPSHOT"
val pekCommonsVersion = pekVersion
val pekInstancesVersion = pekVersion
val pekLoggingVersion = pekVersion
val pekCodecVersion = pekVersion
val pekQueryVersion = pekVersion
val pekApiVersion = pekVersion
val pekAuthVersion = pekVersion

val log4CatsSlf4j = "org.typelevel" %% "log4cats-slf4j" % log4CatsVersion
val logbackClassic = "ch.qos.logback" % "logback-classic" % logbackVersion
