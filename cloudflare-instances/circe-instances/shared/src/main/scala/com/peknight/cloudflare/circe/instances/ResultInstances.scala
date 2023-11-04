package com.peknight.cloudflare.circe.instances

import com.peknight.cloudflare.Result
import com.peknight.generic.circe.CodecInstances
import com.peknight.generic.circe.all.given
import com.peknight.generic.deriving.Generic
import io.circe.{Codec, Decoder, Encoder}

trait ResultInstances extends ConfigurationInstances:
  given [A: Decoder: Encoder]: Codec[Result[A]] =
    CodecInstances.derivedConfiguredCodec(configuration)
  end given
end ResultInstances
object ResultInstances extends ResultInstances
