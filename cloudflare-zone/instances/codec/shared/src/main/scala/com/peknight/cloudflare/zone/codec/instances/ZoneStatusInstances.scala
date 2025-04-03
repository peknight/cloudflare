package com.peknight.cloudflare.zone.codec.instances

import cats.Applicative
import com.peknight.cloudflare.zone.ZoneStatus
import com.peknight.codec.Codec
import com.peknight.codec.configuration.{CodecConfiguration, Configuration}
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.derivation.EnumCodecDerivation
import com.peknight.codec.sum.StringType
import com.peknight.commons.string.cases.SnakeCase
import com.peknight.commons.string.syntax.cases.to

trait ZoneStatusInstances:
  given stringCodecZoneStatus[F[_]: Applicative]: Codec[F, String, String, ZoneStatus] =
    EnumCodecDerivation.unsafeDerived[F, String, String, ZoneStatus](
      using CodecConfiguration.default.withTransformConstructorName(_.to(SnakeCase))
    )

  given codecZoneStatusS[F[_], S](using Configuration, Applicative[F], StringType[S])
  : Codec[F, S, Cursor[S], ZoneStatus] =
    Codec.codecS[F, S, ZoneStatus]
end ZoneStatusInstances
object ZoneStatusInstances extends ZoneStatusInstances
