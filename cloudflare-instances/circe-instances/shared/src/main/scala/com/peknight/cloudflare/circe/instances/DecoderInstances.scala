package com.peknight.cloudflare.circe.instances

import io.circe.Decoder
import io.circe.`export`.Exported
import io.circe.derivation.Configuration

import scala.deriving.Mirror

trait DecoderInstances:
  inline given [A](using inline mirror: Mirror.Of[A]): Exported[Decoder[A]] =
    Exported(Decoder.derivedConfigured(using mirror, Configuration.default.withSnakeCaseMemberNames))
end DecoderInstances
object DecoderInstances extends DecoderInstances
