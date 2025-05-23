package com.peknight.cloudflare.codec.instances.query

import cats.{Applicative, Show}
import com.peknight.cloudflare.query.Direction
import com.peknight.codec.Codec
import com.peknight.codec.config.{CodecConfig, Config}
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.derivation.EnumCodecDerivation
import com.peknight.codec.sum.StringType
import com.peknight.commons.text.cases.SnakeCase
import com.peknight.commons.text.syntax.cases.to

trait DirectionInstances:
  given stringCodecDirection[F[_]: Applicative]: Codec[F, String, String, Direction] =
    EnumCodecDerivation.unsafeDerived[F, String, String, Direction](
      using CodecConfig.default.withTransformConstructorName(_.to(SnakeCase))
    )

  given codecDirectionS[F[_], S](using Config, Applicative[F], StringType[S], Show[S]): Codec[F, S, Cursor[S], Direction] =
    Codec.codecS[F, S, Direction]
end DirectionInstances
object DirectionInstances extends DirectionInstances
