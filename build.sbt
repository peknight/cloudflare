import com.peknight.build.gav.*
import com.peknight.build.sbt.*

commonSettings

ThisBuild / organization := "com.peknight.cloudflare"

lazy val cloudflare = (project in file("."))
  .settings(name := "cloudflare")
  .aggregate(cloudflareCore.projectRefs *)
  .aggregate(cloudflareHttp4s.projectRefs *)
  .aggregate(cloudflareZone.projectRefs *)
  .aggregate(cloudflareDNS.projectRefs *)

lazy val cloudflareCore = (projectMatrix in file("cloudflare-core"))
  .settings(name := "core")
  .settings(libraryDependencies ++= dependencies(
    peknight.api,
    peknight.query,
    peknight.commons.text,
  ))
  .jvmPlatform(scalaVersions = Seq(scala.scala3.version))
  .jsPlatform(scalaVersions = Seq(scala.scala3.version))

lazy val cloudflareHttp4s = (projectMatrix in file("cloudflare-http4s"))
  .dependsOn(cloudflareCore)
  .settings(name := "http4s")
  .settings(libraryDependencies ++= dependencies(http4s))
  .jvmPlatform(scalaVersions = Seq(scala.scala3.version))
  .jsPlatform(scalaVersions = Seq(scala.scala3.version))

lazy val cloudflareZone = (projectMatrix in file("cloudflare-zone"))
  .settings(name := "zone")
  .aggregate(cloudflareZoneCore.projectRefs *)
  .aggregate(cloudflareZoneConfig.projectRefs *)
  .aggregate(cloudflareZoneApi.projectRefs *)
  .aggregate(cloudflareZoneHttp4s.projectRefs *)
  .jvmPlatform(scalaVersions = Seq(scala.scala3.version))
  .jsPlatform(scalaVersions = Seq(scala.scala3.version))

lazy val cloudflareZoneCore = (projectMatrix in file("cloudflare-zone/core"))
  .dependsOn(cloudflareCore)
  .settings(name := "zone-core")
  .settings(libraryDependencies ++= dependencies(
    peknight.codec.ip4s,
    peknight.codec.effect,
  ))
  .settings(libraryDependencies ++= testDependencies(
    peknight.codec.circe.parser,
    scalaTest,
  ))
  .jvmPlatform(scalaVersions = Seq(scala.scala3.version))
  .jsPlatform(scalaVersions = Seq(scala.scala3.version))

lazy val cloudflareZoneConfig = (projectMatrix in file("cloudflare-zone/config"))
  .dependsOn(cloudflareZoneCore)
  .settings(name := "zone-config")
  .settings(libraryDependencies ++= dependencies(peknight.auth))
  .jvmPlatform(scalaVersions = Seq(scala.scala3.version))
  .jsPlatform(scalaVersions = Seq(scala.scala3.version))

lazy val cloudflareZoneApi = (projectMatrix in file("cloudflare-zone/api"))
  .dependsOn(cloudflareZoneCore)
  .settings(name := "zone-api")
  .jvmPlatform(scalaVersions = Seq(scala.scala3.version))
  .jsPlatform(scalaVersions = Seq(scala.scala3.version))

lazy val cloudflareZoneHttp4s = (projectMatrix in file("cloudflare-zone/http4s"))
  .dependsOn(cloudflareZoneApi, cloudflareHttp4s)
  .settings(name := "zone-http4s")
  .settings(libraryDependencies ++= dependencies(
    http4s.client,
    peknight.codec.http4s.circe,
    peknight.query.http4s,
    peknight.auth.http4s,
  ))
  .settings(libraryDependencies ++= testDependencies(
    http4s.ember.client,
    peknight.logging,
    peknight.logging.logback.config,
    scalaTest.flatSpec,
    typelevel.catsEffect.testingScalaTest,
  ))
  .jvmPlatform(
    scalaVersions = Seq(scala.scala3.version),
    settings = Seq(
      libraryDependencies ++= testDependencies(typelevel.log4Cats.slf4j),
      libraryDependencies ++= jvmTestDependencies(logback.classic),
    )
  )
  .jsPlatform(scalaVersions = Seq(scala.scala3.version))

lazy val cloudflareDNS = (projectMatrix in file("cloudflare-dns"))
  .settings(name := "dns")
  .aggregate(cloudflareDNSRecord.projectRefs *)
  .jvmPlatform(scalaVersions = Seq(scala.scala3.version))
  .jsPlatform(scalaVersions = Seq(scala.scala3.version))

lazy val cloudflareDNSRecord = (projectMatrix in file("cloudflare-dns/record"))
  .settings(name := "dns-record")
  .aggregate(cloudflareDNSRecordCore.projectRefs *)
  .aggregate(cloudflareDNSRecordApi.projectRefs *)
  .aggregate(cloudflareDNSRecordHttp4s.projectRefs *)
  .jvmPlatform(scalaVersions = Seq(scala.scala3.version))
  .jsPlatform(scalaVersions = Seq(scala.scala3.version))

lazy val cloudflareDNSRecordCore = (projectMatrix in file("cloudflare-dns/record/core"))
  .dependsOn(cloudflareZoneCore)
  .settings(name := "dns-record-core")
  .settings(libraryDependencies ++= testDependencies(
    peknight.codec.circe.parser,
    scalaTest,
  ))
  .jvmPlatform(scalaVersions = Seq(scala.scala3.version))
  .jsPlatform(scalaVersions = Seq(scala.scala3.version))

lazy val cloudflareDNSRecordApi = (projectMatrix in file("cloudflare-dns/record/api"))
  .dependsOn(cloudflareDNSRecordCore)
  .settings(name := "dns-record-api")
  .jvmPlatform(scalaVersions = Seq(scala.scala3.version))
  .jsPlatform(scalaVersions = Seq(scala.scala3.version))

lazy val cloudflareDNSRecordHttp4s = (projectMatrix in file("cloudflare-dns/record/http4s"))
  .dependsOn(cloudflareDNSRecordApi, cloudflareHttp4s)
  .dependsOn(cloudflareZoneConfig % Test)
  .settings(name := "dns-record-http4s")
  .settings(libraryDependencies ++= dependencies(
    http4s.client,
    peknight.codec.http4s,
    peknight.codec.http4s.circe,
    peknight.query.http4s,
    peknight.auth.http4s,
  ))
  .settings(libraryDependencies ++= testDependencies(
    http4s.ember.client,
    peknight.logging,
    peknight.logging.logback.config,
    scalaTest.flatSpec,
    typelevel.catsEffect.testingScalaTest,
  ))
  .jvmPlatform(
    scalaVersions = Seq(scala.scala3.version),
    settings = Seq(
      libraryDependencies ++= testDependencies(typelevel.log4Cats.slf4j),
      libraryDependencies ++= jvmTestDependencies(logback.classic),
    )
  )
  .jsPlatform(scalaVersions = Seq(scala.scala3.version))
