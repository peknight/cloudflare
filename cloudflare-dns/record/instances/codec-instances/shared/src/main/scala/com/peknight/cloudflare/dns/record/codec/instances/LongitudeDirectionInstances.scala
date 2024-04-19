package com.peknight.cloudflare.dns.record.codec.instances

import cats.Applicative
import com.peknight.cloudflare.dns.record.LongitudeDirection
import com.peknight.codec.Codec
import com.peknight.codec.configuration.Configuration
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.derivation.EnumCodecDerivation
import com.peknight.codec.sum.StringType

trait LongitudeDirectionInstances:
  given stringCodecLongitudeDirection[F[_], S](using Configuration, Applicative[F])
  : Codec[F, String, String, LongitudeDirection] =
    EnumCodecDerivation.unsafeDerived[F, String, String, LongitudeDirection]

  given codecLongitudeDirectionS[F[_], S](using Configuration, Applicative[F], StringType[S])
  : Codec[F, S, Cursor[S], LongitudeDirection] =
    Codec.codecS[F, S, LongitudeDirection]
end LongitudeDirectionInstances
object LongitudeDirectionInstances extends LongitudeDirectionInstances
