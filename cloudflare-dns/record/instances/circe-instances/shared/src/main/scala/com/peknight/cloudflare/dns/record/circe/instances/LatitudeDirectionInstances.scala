package com.peknight.cloudflare.dns.record.circe.instances

import com.peknight.cloudflare.circe.instances.configuration.given
import com.peknight.cloudflare.dns.record.LatitudeDirection
import io.circe.Codec
import io.circe.derivation.ConfiguredEnumCodec

trait LatitudeDirectionInstances:
  given Codec[LatitudeDirection] = ConfiguredEnumCodec.derived[LatitudeDirection]
end LatitudeDirectionInstances
object LatitudeDirectionInstances extends LatitudeDirectionInstances
