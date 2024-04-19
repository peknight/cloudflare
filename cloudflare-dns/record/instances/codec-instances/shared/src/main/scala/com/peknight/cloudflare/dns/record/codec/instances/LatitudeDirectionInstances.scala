package com.peknight.cloudflare.dns.record.codec.instances

import cats.Applicative
import com.peknight.cloudflare.dns.record.LatitudeDirection
import com.peknight.codec.Codec
import com.peknight.codec.configuration.Configuration
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.derivation.EnumCodecDerivation
import com.peknight.codec.sum.StringType

trait LatitudeDirectionInstances:
  given stringCodecLatitudeDirection[F[_]](using Configuration, Applicative[F])
  : Codec[F, String, String, LatitudeDirection] =
    EnumCodecDerivation.unsafeDerived[F, String, String, LatitudeDirection]

  given codecLatitudeDirectionS[F[_], S](using Configuration, Applicative[F], StringType[S])
  : Codec[F, S, Cursor[S], LatitudeDirection] =
    Codec.codecS[F, S, LatitudeDirection]
end LatitudeDirectionInstances
object LatitudeDirectionInstances extends LatitudeDirectionInstances
