package com.peknight.cloudflare.query

import cats.{Applicative, Eq, Show}
import com.peknight.cloudflare.query.Direction
import com.peknight.codec.Codec
import com.peknight.codec.config.CodecConfig
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.derivation.EnumCodecDerivation
import com.peknight.codec.sum.StringType
import com.peknight.commons.text.cases.SnakeCase
import com.peknight.commons.text.syntax.cases.to

enum Direction derives CanEqual:
  case Desc, Asc
end Direction
object Direction:
  given stringCodecDirection[F[_]: Applicative]: Codec[F, String, String, Direction] =
    given CodecConfig = CodecConfig.default.withTransformConstructorName(_.to(SnakeCase))
    EnumCodecDerivation.unsafeDerived[F, String, String, Direction]
  given codecDirectionS[F[_]: Applicative, S: {StringType, Show}]: Codec[F, S, Cursor[S], Direction] =
    Codec.codecS[F, S, Direction]
  given eqDirection: Eq[Direction] = Eq.fromUniversalEquals[Direction]
  given showDirection: Show[Direction] = Show.fromToString[Direction]
end Direction