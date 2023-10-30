package com.peknight.cloudflare.zone.circe.instances

import com.peknight.cloudflare.Result
import com.peknight.cloudflare.circe.instances.configuration.given
import com.peknight.cloudflare.zone.Zone
import com.peknight.cloudflare.zone.circe.instances.ZoneCirceInstancesCases.*
import com.peknight.cloudflare.zone.circe.instances.all.given
import com.peknight.generic.circe.decoder.given
import io.circe.parser.decode
import org.scalatest.flatspec.AnyFlatSpec

class ZoneCirceInstancesFlatSpec extends AnyFlatSpec:

  "CloudFlare Zone's circe instances" should "succeed" in {
    val result = decode[Result[List[Zone]]](listZonesSucceed)
    println(result)
    assert(result.isRight)
  }
end ZoneCirceInstancesFlatSpec
