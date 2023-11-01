package com.peknight.cloudflare.zone.circe.instances

import com.peknight.cloudflare.zone.ZoneId
import io.circe.{Codec, Decoder, Encoder}

trait ZoneIdInstances:
  given Codec[ZoneId] = Codec.from(Decoder.decodeString.map(ZoneId.apply), Encoder.encodeString.contramap(_.id))
end ZoneIdInstances
object ZoneIdInstances extends ZoneIdInstances
