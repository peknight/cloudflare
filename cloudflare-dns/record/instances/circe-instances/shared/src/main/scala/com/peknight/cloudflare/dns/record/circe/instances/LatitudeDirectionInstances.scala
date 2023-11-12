package com.peknight.cloudflare.dns.record.circe.instances

import com.peknight.cloudflare.dns.record.LatitudeDirection
import io.circe.Codec
import io.circe.derivation.{Configuration, ConfiguredEnumCodec}

trait LatitudeDirectionInstances:
  given Codec[LatitudeDirection] =
    ConfiguredEnumCodec.derived[LatitudeDirection](using Configuration.default.withSnakeCaseMemberNames)
end LatitudeDirectionInstances
object LatitudeDirectionInstances extends LatitudeDirectionInstances
