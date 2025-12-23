import com.peknight.build.gav.*
import com.peknight.build.sbt.*

commonSettings

ThisBuild / organization := "com.peknight.cloudflare"

lazy val cloudflare = (project in file("."))
  .settings(name := "cloudflare")
  .aggregate(
    cloudflareCore.jvm,
    cloudflareCore.js,
    cloudflareHttp4s.jvm,
    cloudflareHttp4s.js,
    cloudflareZone,
    cloudflareDNS,
  )

lazy val cloudflareCore = (crossProject(JVMPlatform, JSPlatform) in file("cloudflare-core"))
  .settings(name := "core")
  .settings(crossDependencies(
    peknight.api,
    peknight.query,
    peknight.commons.text,
  ))

lazy val cloudflareHttp4s = (crossProject(JVMPlatform, JSPlatform) in file("cloudflare-http4s"))
  .dependsOn(cloudflareCore)
  .settings(name := "http4s")
  .settings(crossDependencies(http4s))

lazy val cloudflareZone = (project in file("cloudflare-zone"))
  .settings(name := "zone")
  .aggregate(
    cloudflareZoneCore.jvm,
    cloudflareZoneCore.js,
    cloudflareZoneConfig.jvm,
    cloudflareZoneConfig.js,
    cloudflareZoneApi.jvm,
    cloudflareZoneApi.js,
    cloudflareZoneHttp4s.jvm,
    cloudflareZoneHttp4s.js,
  )

lazy val cloudflareZoneCore = (crossProject(JVMPlatform, JSPlatform) in file("cloudflare-zone/core"))
  .dependsOn(cloudflareCore)
  .settings(name := "zone-core")
  .settings(crossDependencies(
    peknight.codec.ip4s,
    peknight.codec.effect,
  ))
  .settings(crossTestDependencies(
    peknight.codec.circe.parser,
    scalaTest,
  ))

lazy val cloudflareZoneConfig = (crossProject(JVMPlatform, JSPlatform) in file("cloudflare-zone/config"))
  .dependsOn(cloudflareZoneCore)
  .settings(name := "zone-config")
  .settings(crossDependencies(peknight.auth))

lazy val cloudflareZoneApi = (crossProject(JVMPlatform, JSPlatform) in file("cloudflare-zone/api"))
  .dependsOn(cloudflareZoneCore)
  .settings(name := "zone-api")

lazy val cloudflareZoneHttp4s = (crossProject(JVMPlatform, JSPlatform) in file("cloudflare-zone/http4s"))
  .dependsOn(
    cloudflareZoneApi,
    cloudflareHttp4s,
  )
  .settings(name := "zone-http4s")
  .settings(crossDependencies(
    http4s.client,
    peknight.codec.http4s.circe,
    peknight.query.http4s,
    peknight.auth.http4s,
  ))
  .settings(crossTestDependencies(
    http4s.ember.client,
    peknight.logging,
    peknight.logging.logback.config,
    scalaTest.flatSpec,
    typelevel.catsEffect.testingScalaTest,
  ))
  .jvmSettings(libraryDependencies ++= Seq(
    testDependency(typelevel.log4Cats.slf4j),
    jvmTestDependency(logback.classic),
  ))

lazy val cloudflareDNS = (project in file("cloudflare-dns"))
  .settings(name := "dns")
  .aggregate(cloudflareDNSRecord)

lazy val cloudflareDNSRecord = (project in file("cloudflare-dns/record"))
  .settings(name := "dns-record")
  .aggregate(
    cloudflareDNSRecordCore.jvm,
    cloudflareDNSRecordCore.js,
    cloudflareDNSRecordApi.jvm,
    cloudflareDNSRecordApi.js,
    cloudflareDNSRecordHttp4s.jvm,
    cloudflareDNSRecordHttp4s.js,
  )

lazy val cloudflareDNSRecordCore = (crossProject(JVMPlatform, JSPlatform) in file("cloudflare-dns/record/core"))
  .dependsOn(cloudflareZoneCore)
  .settings(name := "dns-record-core")
  .settings(crossTestDependencies(
    peknight.codec.circe.parser,
    scalaTest,
  ))

lazy val cloudflareDNSRecordApi = (crossProject(JVMPlatform, JSPlatform) in file("cloudflare-dns/record/api"))
  .settings(name := "dns-record-api")
  .dependsOn(cloudflareDNSRecordCore)

lazy val cloudflareDNSRecordHttp4s = (crossProject(JVMPlatform, JSPlatform) in file("cloudflare-dns/record/http4s"))
  .dependsOn(
    cloudflareDNSRecordApi,
    cloudflareHttp4s,
    cloudflareZoneConfig % Test,
  )
  .settings(name := "dns-record-http4s")
  .settings(crossDependencies(
    http4s.client,
    peknight.codec.http4s,
    peknight.codec.http4s.circe,
    peknight.query.http4s,
    peknight.auth.http4s,
  ))
  .settings(crossTestDependencies(
    http4s.ember.client,
    peknight.logging,
    peknight.logging.logback.config,
    scalaTest.flatSpec,
    typelevel.catsEffect.testingScalaTest,
  ))
  .jvmSettings(libraryDependencies ++= Seq(
    testDependency(typelevel.log4Cats.slf4j),
    jvmTestDependency(logback.classic),
  ))
