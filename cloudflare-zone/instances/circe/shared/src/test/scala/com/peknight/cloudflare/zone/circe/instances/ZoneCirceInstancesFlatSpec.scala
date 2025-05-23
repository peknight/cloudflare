package com.peknight.cloudflare.zone.circe.instances

import cats.Id
import com.peknight.cloudflare.Result
import com.peknight.cloudflare.circe.instances.result.given
import com.peknight.cloudflare.codec.instances.config.given
import com.peknight.cloudflare.zone.Zone
import com.peknight.cloudflare.zone.circe.instances.ZoneCirceInstancesCases.*
import com.peknight.cloudflare.zone.circe.instances.zone.given
import com.peknight.codec.circe.parser.decode
import com.peknight.codec.circe.sum.jsonType.given
import org.scalatest.flatspec.AnyFlatSpec

class ZoneCirceInstancesFlatSpec extends AnyFlatSpec:

  "CloudFlare Zone's circe instances" should "parse succeed json" in {
    val result = decode[Id, Result[List[Zone]]](listZonesSucceed)
    assert(result.isRight)
  }

  "CloudFlare Zone's circe instances" should "parse failed json" in {
    val result = decode[Id, Result[List[Zone]]](listZonesFailed)
    assert(result.isRight)
  }
end ZoneCirceInstancesFlatSpec
