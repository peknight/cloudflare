package com.peknight.cloudflare.zone.http4s

import cats.effect.IO
import cats.effect.testing.scalatest.AsyncIOSpec
import com.peknight.cloudflare.test.PekToken
import org.http4s.client.dsl
import org.http4s.ember.client.EmberClientBuilder
import org.scalatest.flatspec.AsyncFlatSpec

class ZoneApiFlatSpec extends AsyncFlatSpec with AsyncIOSpec:
  "CloudFlare Zone Api List Zones" should "succeed" in {
    // EmberClientBuilder.default[IO].build
    //   .use(client => ZoneApi[IO](client)(dsl.io).listZones(PekToken.token))
    //   .asserting { result =>
    //     println(result)
    //     assert(result.result.isDefined)
    //   }
  }
end ZoneApiFlatSpec
