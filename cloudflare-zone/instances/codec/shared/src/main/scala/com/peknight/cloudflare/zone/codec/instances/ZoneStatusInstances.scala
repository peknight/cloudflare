package com.peknight.cloudflare.zone.codec.instances

import cats.{Applicative, Show}
import com.peknight.cloudflare.zone.ZoneStatus
import com.peknight.codec.Codec
import com.peknight.codec.config.{CodecConfig, Config}
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.derivation.EnumCodecDerivation
import com.peknight.codec.sum.StringType
import com.peknight.commons.text.cases.SnakeCase
import com.peknight.commons.text.syntax.cases.to

trait ZoneStatusInstances:
  given stringCodecZoneStatus[F[_]: Applicative]: Codec[F, String, String, ZoneStatus] =
    EnumCodecDerivation.unsafeDerived[F, String, String, ZoneStatus](
      using CodecConfig.default.withTransformConstructorName(_.to(SnakeCase))
    )

  given codecZoneStatusS[F[_], S](using Config, Applicative[F], StringType[S], Show[S])
  : Codec[F, S, Cursor[S], ZoneStatus] =
    Codec.codecS[F, S, ZoneStatus]
end ZoneStatusInstances
object ZoneStatusInstances extends ZoneStatusInstances
