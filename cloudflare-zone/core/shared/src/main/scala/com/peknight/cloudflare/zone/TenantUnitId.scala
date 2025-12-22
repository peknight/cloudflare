package com.peknight.cloudflare.zone

import cats.{Applicative, Show}
import com.peknight.codec.Codec
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.sum.StringType

case class TenantUnitId(id: String) extends AnyVal
object TenantUnitId:
  given stringCodecTenantUnitId[F[_]: Applicative]: Codec[F, String, String, TenantUnitId] =
    Codec.map[F, String, String, TenantUnitId](_.id)(TenantUnitId.apply)

  given codecTenantUnitIdS[F[_]: Applicative, S: {StringType, Show}]: Codec[F, S, Cursor[S], TenantUnitId] =
    Codec.codecS[F, S, TenantUnitId]
end TenantUnitId

