package com.peknight.cloudflare.zone.codec.instances

import cats.Applicative
import com.peknight.cloudflare.zone.ZoneStatus
import com.peknight.codec.Codec
import com.peknight.codec.configuration.Configuration
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.derivation.EnumCodecDerivation
import com.peknight.codec.sum.StringType

trait ZoneStatusInstances:
  given stringCodecZoneStatus[F[_], S](using Configuration, Applicative[F]): Codec[F, String, String, ZoneStatus] =
    EnumCodecDerivation.unsafeDerived[F, String, String, ZoneStatus]

  given codecZoneStatusS[F[_], S](using Configuration, Applicative[F], StringType[S])
  : Codec[F, S, Cursor[S], ZoneStatus] =
    Codec.codecS[F, S, ZoneStatus]
end ZoneStatusInstances
object ZoneStatusInstances extends ZoneStatusInstances
