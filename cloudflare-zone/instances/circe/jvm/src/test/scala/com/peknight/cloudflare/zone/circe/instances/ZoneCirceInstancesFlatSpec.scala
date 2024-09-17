package com.peknight.cloudflare.zone.circe.instances

import com.peknight.cloudflare.Result
import com.peknight.cloudflare.circe.instances.result.given
import com.peknight.cloudflare.codec.instances.configuration.given
import com.peknight.cloudflare.zone.Zone
import com.peknight.cloudflare.zone.circe.instances.ZoneCirceInstancesCases.*
import com.peknight.cloudflare.zone.circe.instances.zone.given
import com.peknight.codec.circe.instances.all.given
import io.circe.parser.decode
import org.scalatest.flatspec.AnyFlatSpec

class ZoneCirceInstancesFlatSpec extends AnyFlatSpec:

  "CloudFlare Zone's circe instances" should "parse succeed json" in {
    val result = decode[Result[List[Zone]]](listZonesSucceed)
    assert(result.isRight)
  }

  "CloudFlare Zone's circe instances" should "parse failed json" in {
    val result = decode[Result[List[Zone]]](listZonesFailed)
    assert(result.isRight)
  }
end ZoneCirceInstancesFlatSpec
