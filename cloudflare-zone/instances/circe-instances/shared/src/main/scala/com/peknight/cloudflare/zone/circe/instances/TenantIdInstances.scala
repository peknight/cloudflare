package com.peknight.cloudflare.zone.circe.instances

import com.peknight.cloudflare.zone.TenantId
import io.circe.{Codec, Decoder, Encoder}

trait TenantIdInstances:
  given Codec[TenantId] = Codec.from(Decoder.decodeString.map(TenantId.apply), Encoder.encodeString.contramap(_.id))
end TenantIdInstances
object TenantIdInstances extends TenantIdInstances
