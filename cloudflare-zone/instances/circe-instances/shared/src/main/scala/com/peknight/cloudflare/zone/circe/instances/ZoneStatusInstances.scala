package com.peknight.cloudflare.zone.circe.instances

import com.peknight.cloudflare.circe.instances.configuration.configuration
import com.peknight.cloudflare.zone.ZoneStatus
import io.circe.Codec
import io.circe.derivation.ConfiguredEnumCodec

trait ZoneStatusInstances:
  given Codec[ZoneStatus] = ConfiguredEnumCodec.derived[ZoneStatus](using configuration.withSnakeCaseConstructorNames)
end ZoneStatusInstances
object ZoneStatusInstances extends ZoneStatusInstances
