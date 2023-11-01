package com.peknight.cloudflare.zone.circe.instances

import com.peknight.cloudflare.zone.PlanId
import io.circe.{Codec, Decoder, Encoder}

trait PlanIdInstances:
  given Codec[PlanId] = Codec.from(Decoder.decodeString.map(PlanId.apply), Encoder.encodeString.contramap(_.id))
end PlanIdInstances
object PlanIdInstances extends PlanIdInstances
