package com.peknight.cloudflare.circe.instances

import io.circe.Decoder
import io.circe.derivation.{Configuration, ConfiguredDecoder}

import scala.deriving.Mirror

trait DecoderInstances:
  inline given [A](using mirror: Mirror.Of[A]): Decoder[A] =
    ConfiguredDecoder.derived(using Configuration.default.withSnakeCaseMemberNames)(using mirror)
end DecoderInstances
object DecoderInstances extends DecoderInstances
