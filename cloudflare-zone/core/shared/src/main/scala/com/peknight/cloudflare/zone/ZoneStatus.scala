package com.peknight.cloudflare.zone

import cats.{Applicative, Show}
import com.peknight.codec.Codec
import com.peknight.codec.config.{CodecConfig, Config}
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.derivation.EnumCodecDerivation
import com.peknight.codec.sum.StringType
import com.peknight.commons.text.cases.SnakeCase
import com.peknight.commons.text.syntax.cases.to

enum ZoneStatus:
  case Initializing, Pending, Active, Moved
end ZoneStatus
object ZoneStatus:
  given stringCodecZoneStatus[F[_]: Applicative]: Codec[F, String, String, ZoneStatus] =
    given CodecConfig = CodecConfig.default.withTransformConstructorName(_.to(SnakeCase))
    EnumCodecDerivation.unsafeDerived[F, String, String, ZoneStatus]

  given codecZoneStatusS[F[_], S](using Config, Applicative[F], StringType[S], Show[S])
  : Codec[F, S, Cursor[S], ZoneStatus] =
    Codec.codecS[F, S, ZoneStatus]
end ZoneStatus

