package com.peknight.cloudflare.codec.instances.query

import cats.Applicative
import com.peknight.cloudflare.query.Direction
import com.peknight.codec.Codec
import com.peknight.codec.configuration.{CodecConfiguration, Configuration}
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.derivation.EnumCodecDerivation
import com.peknight.codec.sum.StringType
import com.peknight.commons.string.cases.SnakeCase
import com.peknight.commons.string.syntax.cases.to

trait DirectionInstances:
  given stringCodecDirection[F[_]: Applicative]: Codec[F, String, String, Direction] =
    EnumCodecDerivation.unsafeDerived[F, String, String, Direction](
      using CodecConfiguration.default.withTransformConstructorName(_.to(SnakeCase))
    )

  given codecDirectionS[F[_], S](using Configuration, Applicative[F], StringType[S]): Codec[F, S, Cursor[S], Direction] =
    Codec.codecS[F, S, Direction]
end DirectionInstances
object DirectionInstances extends DirectionInstances
