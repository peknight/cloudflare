package com.peknight.cloudflare.dns.record

import cats.{Applicative, Eq, Show}
import com.peknight.cloudflare.config.given
import com.peknight.codec.Codec
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.derivation.EnumCodecDerivation
import com.peknight.codec.sum.StringType

enum LongitudeDirection derives CanEqual:
  case E, W
end LongitudeDirection
object LongitudeDirection:
  given stringCodecLongitudeDirection[F[_]: Applicative]: Codec[F, String, String, LongitudeDirection] =
    EnumCodecDerivation.unsafeDerived[F, String, String, LongitudeDirection]

  given codecLongitudeDirectionS[F[_]: Applicative, S: {StringType, Show}]: Codec[F, S, Cursor[S], LongitudeDirection] =
    Codec.codecS[F, S, LongitudeDirection]

  given eqLongitudeDirection: Eq[LongitudeDirection] = Eq.fromUniversalEquals[LongitudeDirection]
  given showLongitudeDirection: Show[LongitudeDirection] = Show.fromToString[LongitudeDirection]
end LongitudeDirection
