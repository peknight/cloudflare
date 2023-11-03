package com.peknight.cloudflare.dns.record.http4s

import cats.effect.IO
import cats.effect.testing.scalatest.AsyncIOSpec
import com.peknight.cloudflare.test.PekToken
import org.http4s.ember.client.EmberClientBuilder
import org.scalatest.flatspec.AsyncFlatSpec

class DNSRecordApiFlatSpec extends AsyncFlatSpec with AsyncIOSpec:
  "CloudFlare DNS Records for a Zone Api List DNS Records" should "succeed" in {
    import com.peknight.cloudflare.http4s.headers.toHeader
    import com.peknight.cloudflare.http4s.uri.v4
    import org.http4s.Method.GET
    import org.http4s.client.dsl.io.*
    import org.http4s.Headers
    EmberClientBuilder.default[IO].build
      .use(client => client
        .run(GET(v4 / "zones" / "498823170f9a78cf197934b200d2993e" / "dns_records", Headers(PekToken.token.toHeader)))
        .use(_.as[String])
      )
      .asserting{ result =>
        println(result)
        assert(true)
      }
  }
end DNSRecordApiFlatSpec
