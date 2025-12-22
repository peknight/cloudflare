package com.peknight.cloudflare.zone

import cats.{Applicative, Show}
import com.peknight.codec.Codec
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.sum.StringType

case class ZoneId(id: String) extends AnyVal
object ZoneId:
  given stringCodecZoneId[F[_] : Applicative]: Codec[F, String, String, ZoneId] =
    Codec.map[F, String, String, ZoneId](_.id)(ZoneId.apply)

  given codecZoneIdS[F[_]: Applicative, S: {StringType, Show}]: Codec[F, S, Cursor[S], ZoneId] = Codec.codecS[F, S, ZoneId]

  given showZoneId: Show[ZoneId] = Show.fromToString[ZoneId]
end ZoneId
