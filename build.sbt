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
    cloudflareCirce.jvm,
    cloudflareCirce.js,
    cloudflareZone,
    cloudflareDns,
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

lazy val cloudflareCirce = (crossProject(JSPlatform, JVMPlatform) in file("cloudflare-circe"))
  .settings(commonSettings)
  .settings(
    name := "circe",
    libraryDependencies ++= Seq(
    ),
  )

lazy val cloudflareZone = (project in file("cloudflare-zone"))
  .aggregate(
    cloudflareZoneCore.jvm,
    cloudflareZoneCore.js,
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
  )
  .settings(commonSettings)
  .settings(
    name := "zone-http4s",
    libraryDependencies ++= Seq(
      "org.http4s" %%% "http4s-client" % http4sVersion,
      "org.http4s" %%% "http4s-circe" % http4sVersion,
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

val http4sVersion = "1.0.0-M34"
