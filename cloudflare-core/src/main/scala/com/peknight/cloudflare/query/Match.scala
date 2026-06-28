package com.peknight.cloudflare.query

import cats.{Applicative, Eq, Show}
import com.peknight.codec.Codec
import com.peknight.codec.config.CodecConfig
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.derivation.EnumCodecDerivation
import com.peknight.codec.sum.StringType
import com.peknight.commons.text.cases.SnakeCase
import com.peknight.commons.text.syntax.cases.to

enum Match derives CanEqual:
  case All, Any
end Match
object Match:
  given stringCodecMatch[F[_]: Applicative]: Codec[F, String, String, Match] =
    given CodecConfig = CodecConfig.default.withTransformConstructorName(_.to(SnakeCase))
    EnumCodecDerivation.unsafeDerived[F, String, String, Match]

  given codecMatchS[F[_]: Applicative, S: {StringType, Show}]: Codec[F, S, Cursor[S], Match] =
    Codec.codecS[F, S, Match]

  given eqMatch: Eq[Match] = Eq.fromUniversalEquals[Match]
  given showMatch: Show[Match] = Show.fromToString[Match]
end Match