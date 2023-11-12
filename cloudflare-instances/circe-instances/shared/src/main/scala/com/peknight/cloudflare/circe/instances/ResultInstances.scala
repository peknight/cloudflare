package com.peknight.cloudflare.circe.instances

import com.peknight.cloudflare.Result
import com.peknight.codec.circe.derivation.CodecInstances
import com.peknight.codec.circe.derivation.all.given
import com.peknight.generic.Generic
import io.circe.{Codec, Decoder, Encoder}

trait ResultInstances extends ConfigurationInstances:
  given [A: Decoder: Encoder]: Codec[Result[A]] = CodecInstances.derived
end ResultInstances
object ResultInstances extends ResultInstances
