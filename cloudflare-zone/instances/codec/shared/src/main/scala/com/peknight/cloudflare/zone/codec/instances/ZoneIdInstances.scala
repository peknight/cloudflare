package com.peknight.cloudflare.zone.codec.instances

import cats.{Applicative, Show}
import com.peknight.cloudflare.zone.ZoneId
import com.peknight.codec.Codec
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.sum.StringType

trait ZoneIdInstances:
  given stringCodecZoneId[F[_]: Applicative]: Codec[F, String, String, ZoneId] =
    Codec.map[F, String, String, ZoneId](_.id)(ZoneId.apply)

  given codecZoneIdS[F[_]: Applicative, S: {StringType, Show}]: Codec[F, S, Cursor[S], ZoneId] = Codec.codecS[F, S, ZoneId]
end ZoneIdInstances
object ZoneIdInstances extends ZoneIdInstances
