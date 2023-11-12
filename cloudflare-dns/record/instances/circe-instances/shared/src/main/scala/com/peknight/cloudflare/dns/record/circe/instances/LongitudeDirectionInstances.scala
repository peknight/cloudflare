package com.peknight.cloudflare.dns.record.circe.instances

import com.peknight.cloudflare.dns.record.LongitudeDirection
import io.circe.Codec
import io.circe.derivation.{Configuration, ConfiguredEnumCodec}

trait LongitudeDirectionInstances:
  given Codec[LongitudeDirection] =
    ConfiguredEnumCodec.derived[LongitudeDirection](using Configuration.default.withSnakeCaseMemberNames)
end LongitudeDirectionInstances
object LongitudeDirectionInstances extends LongitudeDirectionInstances
