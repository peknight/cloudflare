package com.peknight.cloudflare.dns.record.circe.instances

import com.peknight.cloudflare.circe.instances.configuration.given
import com.peknight.cloudflare.dns.record.LongitudeDirection
import io.circe.Codec
import io.circe.derivation.ConfiguredEnumCodec

trait LongitudeDirectionInstances:
  given Codec[LongitudeDirection] = ConfiguredEnumCodec.derived[LongitudeDirection]
end LongitudeDirectionInstances
object LongitudeDirectionInstances extends LongitudeDirectionInstances
