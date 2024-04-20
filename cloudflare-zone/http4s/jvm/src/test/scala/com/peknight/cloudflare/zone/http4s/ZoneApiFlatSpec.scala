package com.peknight.cloudflare.zone.http4s

import cats.effect.IO
import cats.syntax.option.*
import cats.effect.testing.scalatest.AsyncIOSpec
import com.peknight.cloudflare.query.Direction.Desc
import com.peknight.cloudflare.query.Match.Any
import com.peknight.cloudflare.query.StringParam
import com.peknight.cloudflare.test.PekToken
import com.peknight.cloudflare.zone.ZoneStatus.Active
import com.peknight.cloudflare.zone.query.Order.Name
import com.peknight.cloudflare.zone.query.{Account, ListZonesQuery}
import org.http4s.client.dsl
import org.http4s.ember.client.EmberClientBuilder
import org.scalatest.flatspec.AsyncFlatSpec

class ZoneApiFlatSpec extends AsyncFlatSpec with AsyncIOSpec:
  "CloudFlare Zone Api List Zones" should "succeed" in {
    val query = ListZonesQuery(
      direction = Desc.some,
      `match` = Any.some,
      order = Name.some,
      name = StringParam(equal = "peknight.com".some).some,
      perPage = 5.some,
      status = Active.some
    )
    EmberClientBuilder.default[IO].build
      .use(client => ZoneApi[IO](client)(dsl.io).listZones(query)(PekToken.token))
      .asserting { result =>
        println(result)
        assert(result.result.isDefined)
      }
  }
end ZoneApiFlatSpec
