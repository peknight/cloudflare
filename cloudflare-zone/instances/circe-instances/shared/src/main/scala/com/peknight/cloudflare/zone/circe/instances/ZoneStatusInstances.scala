package com.peknight.cloudflare.zone.circe.instances

import com.peknight.cloudflare.zone.ZoneStatus
import io.circe.Codec
import io.circe.derivation.{Configuration, ConfiguredEnumCodec}

trait ZoneStatusInstances:
  given Codec[ZoneStatus] = ConfiguredEnumCodec.derived[ZoneStatus](using Configuration.default.withSnakeCaseConstructorNames)
end ZoneStatusInstances
object ZoneStatusInstances extends ZoneStatusInstances
