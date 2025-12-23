package com.peknight.cloudflare.dns.record

import cats.{Applicative, Eq, Show}
import com.peknight.cloudflare.config.given
import com.peknight.codec.Codec
import com.peknight.codec.config.Config
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.derivation.EnumCodecDerivation
import com.peknight.codec.sum.StringType

enum LatitudeDirection derives CanEqual:
  case N, S
end LatitudeDirection
object LatitudeDirection:
  given stringCodecLatitudeDirection[F[_]: Applicative]: Codec[F, String, String, LatitudeDirection] =
    EnumCodecDerivation.unsafeDerived[F, String, String, LatitudeDirection]

  given codecLatitudeDirectionS[F[_]: Applicative, S: {StringType, Show}]: Codec[F, S, Cursor[S], LatitudeDirection] =
    Codec.codecS[F, S, LatitudeDirection]

  given eqLatitudeDirection: Eq[LatitudeDirection] = Eq.fromUniversalEquals[LatitudeDirection]
  given showLatitudeDirection: Show[LatitudeDirection] = Show.fromToString[LatitudeDirection]
end LatitudeDirection
