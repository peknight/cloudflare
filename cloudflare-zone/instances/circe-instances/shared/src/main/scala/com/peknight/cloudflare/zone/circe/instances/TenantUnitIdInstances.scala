package com.peknight.cloudflare.zone.circe.instances

import com.peknight.cloudflare.zone.TenantUnitId
import io.circe.{Codec, Decoder, Encoder}

trait TenantUnitIdInstances:
  given Codec[TenantUnitId] = Codec.from(Decoder.decodeString.map(TenantUnitId.apply), Encoder.encodeString.contramap(_.id))
end TenantUnitIdInstances
object TenantUnitIdInstances extends TenantUnitIdInstances
