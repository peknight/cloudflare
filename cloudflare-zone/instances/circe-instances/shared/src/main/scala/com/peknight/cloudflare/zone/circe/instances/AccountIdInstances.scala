package com.peknight.cloudflare.zone.circe.instances

import com.peknight.cloudflare.zone.AccountId
import io.circe.{Codec, Decoder, Encoder}

trait AccountIdInstances:
  given Codec[AccountId] = Codec.from(Decoder.decodeString.map(AccountId.apply), Encoder.encodeString.contramap(_.id))
end AccountIdInstances
object AccountIdInstances extends AccountIdInstances
