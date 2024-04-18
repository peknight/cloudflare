package com.peknight.cloudflare.dns.record.http4s

import cats.effect.IO
import cats.effect.testing.scalatest.AsyncIOSpec
import com.peknight.cloudflare.test.{PekToken, PekZone}
import org.http4s.client.dsl
import org.http4s.ember.client.EmberClientBuilder
import org.scalatest.flatspec.AsyncFlatSpec

class DNSRecordApiFlatSpec extends AsyncFlatSpec with AsyncIOSpec:
  "CloudFlare DNS Records for a Zone Api List DNS Records" should "succeed" in {
    // EmberClientBuilder.default[IO].build
    //   .use(client => DNSRecordApi[IO](client)(dsl.io).listDNSRecords(PekZone.zoneIdentifier)(PekToken.token))
    //   .asserting{ result =>
    //     println(result)
    //     assert(result.result.isDefined)
    //   }
  }
end DNSRecordApiFlatSpec
