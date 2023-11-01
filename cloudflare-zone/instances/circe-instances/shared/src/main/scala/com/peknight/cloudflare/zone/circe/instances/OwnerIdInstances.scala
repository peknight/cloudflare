package com.peknight.cloudflare.zone.circe.instances

import com.peknight.cloudflare.zone.OwnerId
import io.circe.{Codec, Decoder, Encoder}

trait OwnerIdInstances:
  given Codec[OwnerId] = Codec.from(Decoder.decodeString.map(OwnerId.apply), Encoder.encodeString.contramap(_.id))
end OwnerIdInstances
object OwnerIdInstances extends OwnerIdInstances
