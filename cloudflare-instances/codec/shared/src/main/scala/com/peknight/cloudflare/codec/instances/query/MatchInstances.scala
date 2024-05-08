package com.peknight.cloudflare.codec.instances.query

import cats.Applicative
import com.peknight.cloudflare.query.Match
import com.peknight.codec.Codec
import com.peknight.codec.configuration.{CodecConfiguration, Configuration}
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.derivation.EnumCodecDerivation
import com.peknight.codec.sum.StringType
import com.peknight.commons.string.cases.SnakeCase
import com.peknight.commons.string.syntax.cases.to

trait MatchInstances:
  given stringCodecMatch[F[_]: Applicative]: Codec[F, String, String, Match] =
    EnumCodecDerivation.unsafeDerived[F, String, String, Match](
      using CodecConfiguration(transformConstructorNames = _.to(SnakeCase))
    )

  given codecMatchS[F[_], S](using Configuration, Applicative[F], StringType[S]): Codec[F, S, Cursor[S], Match] =
    Codec.codecS[F, S, Match]
end MatchInstances
object MatchInstances extends MatchInstances
