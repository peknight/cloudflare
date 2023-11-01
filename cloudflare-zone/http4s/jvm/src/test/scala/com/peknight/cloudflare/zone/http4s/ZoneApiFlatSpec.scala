package com.peknight.cloudflare.zone.http4s

import cats.effect.IO
import cats.effect.testing.scalatest.AsyncIOSpec
import com.peknight.cloudflare.test.PekToken
import org.http4s.client.dsl
import org.http4s.ember.client.EmberClientBuilder
import org.scalatest.flatspec.AsyncFlatSpec

import java.time.OffsetDateTime

class ZoneApiFlatSpec extends AsyncFlatSpec with AsyncIOSpec:
  "CloudFlare Zone Api List Zones" should "succeed" in {
    EmberClientBuilder.default[IO].build
      .use(client => ZoneApi[IO](client)(dsl.io).listZones[OffsetDateTime](PekToken.token))
      .asserting(result => assert(result.result.isDefined))
  }
end ZoneApiFlatSpec
