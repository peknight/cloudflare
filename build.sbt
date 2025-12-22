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
    cloudflareZoneInstances,
    cloudflareZoneApi.jvm,
    cloudflareZoneApi.js,
    cloudflareZoneHttp4s.jvm,
    cloudflareZoneHttp4s.js,
  )

lazy val cloudflareZoneCore = (crossProject(JVMPlatform, JSPlatform) in file("cloudflare-zone/core"))
  .dependsOn(cloudflareCore)
  .settings(name := "zone-core")
  .settings(crossDependencies(comcast.ip4s))

lazy val cloudflareZoneConfig = (crossProject(JVMPlatform, JSPlatform) in file("cloudflare-zone/config"))
  .dependsOn(cloudflareZoneCore)
  .settings(name := "zone-config")
  .settings(crossDependencies(peknight.auth))

lazy val cloudflareZoneInstances = (project in file("cloudflare-zone/instances"))
  .settings(name := "zone-instances")
  .aggregate(
    cloudflareZoneCodecInstances.jvm,
    cloudflareZoneCodecInstances.js,
    cloudflareZoneCirceInstances.jvm,
    cloudflareZoneCirceInstances.js,
    cloudflareZoneQueryInstances.jvm,
    cloudflareZoneQueryInstances.js,
  )

lazy val cloudflareZoneCodecInstances = (crossProject(JVMPlatform, JSPlatform) in file("cloudflare-zone/instances/codec"))
  .dependsOn(
    cloudflareZoneCore,
    cloudflareZoneConfig,
  )
  .settings(name := "zone-codec-instances")
  .settings(crossDependencies(
    peknight.codec.effect,
    peknight.codec.ip4s,
    peknight.commons.text,
  ))

lazy val cloudflareZoneCirceInstances = (crossProject(JVMPlatform, JSPlatform) in file("cloudflare-zone/instances/circe"))
  .dependsOn(
    cloudflareZoneCodecInstances,
  )
  .settings(name := "zone-circe-instances")
  .settings(crossDependencies(peknight.codec.circe))
  .settings(crossTestDependencies(
    peknight.codec.circe.parser,
    scalaTest,
  ))

lazy val cloudflareZoneQueryInstances = (crossProject(JVMPlatform, JSPlatform) in file("cloudflare-zone/instances/query"))
  .dependsOn(
    cloudflareZoneCodecInstances,
  )
  .settings(name := "zone-query-instances")
  .settings(crossDependencies(peknight.query))

lazy val cloudflareZoneApi = (crossProject(JVMPlatform, JSPlatform) in file("cloudflare-zone/api"))
  .dependsOn(cloudflareZoneCore)
  .settings(name := "zone-api")

lazy val cloudflareZoneHttp4s = (crossProject(JVMPlatform, JSPlatform) in file("cloudflare-zone/http4s"))
  .dependsOn(
    cloudflareZoneApi,
    cloudflareHttp4s,
    cloudflareZoneCirceInstances,
    cloudflareZoneQueryInstances,
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
    cloudflareDNSRecordInstances,
    cloudflareDNSRecordApi.jvm,
    cloudflareDNSRecordApi.js,
    cloudflareDNSRecordHttp4s.jvm,
    cloudflareDNSRecordHttp4s.js,
  )

lazy val cloudflareDNSRecordCore = (crossProject(JVMPlatform, JSPlatform) in file("cloudflare-dns/record/core"))
  .dependsOn(cloudflareZoneCore)
  .settings(name := "dns-record-core")

lazy val cloudflareDNSRecordInstances = (project in file("cloudflare-dns/record/instances"))
  .settings(name := "dns-record-instances")
  .aggregate(
    cloudflareDNSRecordCodecInstances.jvm,
    cloudflareDNSRecordCodecInstances.js,
    cloudflareDNSRecordCirceInstances.jvm,
    cloudflareDNSRecordCirceInstances.js,
    cloudflareDNSRecordQueryInstances.jvm,
    cloudflareDNSRecordQueryInstances.js,
  )

lazy val cloudflareDNSRecordCodecInstances = (crossProject(JVMPlatform, JSPlatform) in file("cloudflare-dns/record/instances/codec"))
  .dependsOn(
    cloudflareDNSRecordCore,
    cloudflareZoneCodecInstances,
  )
  .settings(name := "dns-record-codec-instances")
  .settings(crossDependencies(
    peknight.codec.ip4s,
    peknight.instances.cats.time,
  ))

lazy val cloudflareDNSRecordCirceInstances = (crossProject(JVMPlatform, JSPlatform) in file("cloudflare-dns/record/instances/circe"))
  .dependsOn(
    cloudflareDNSRecordCodecInstances,
  )
  .settings(name := "dns-record-circe-instances")
  .settings(crossDependencies(
    peknight.codec.circe,
  ))
  .settings(crossTestDependencies(
    peknight.codec.circe.parser,
    scalaTest,
  ))

lazy val cloudflareDNSRecordQueryInstances = (crossProject(JVMPlatform, JSPlatform) in file("cloudflare-dns/record/instances/query"))
  .dependsOn(
    cloudflareDNSRecordCodecInstances,
  )
  .settings(name := "dns-record-query-instances")
  .settings(crossDependencies(peknight.query))

lazy val cloudflareDNSRecordApi = (crossProject(JVMPlatform, JSPlatform) in file("cloudflare-dns/record/api"))
  .settings(name := "dns-record-api")
  .dependsOn(cloudflareDNSRecordCore)

lazy val cloudflareDNSRecordHttp4s = (crossProject(JVMPlatform, JSPlatform) in file("cloudflare-dns/record/http4s"))
  .dependsOn(
    cloudflareDNSRecordApi,
    cloudflareHttp4s,
    cloudflareDNSRecordCirceInstances,
    cloudflareDNSRecordQueryInstances,
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
