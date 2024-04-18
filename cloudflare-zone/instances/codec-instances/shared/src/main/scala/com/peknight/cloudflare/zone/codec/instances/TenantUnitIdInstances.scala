package com.peknight.cloudflare.zone.codec.instances

import cats.Applicative
import com.peknight.cloudflare.zone.TenantUnitId
import com.peknight.codec.Codec
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.sum.StringType

trait TenantUnitIdInstances:
  given stringCodecTenantUnitId[F[_]: Applicative]: Codec[F, String, String, TenantUnitId] =
    Codec.map[F, String, String, TenantUnitId](_.id)(TenantUnitId.apply)

  given codecTenantUnitIdS[F[_]: Applicative, S: StringType]: Codec[F, S, Cursor[S], TenantUnitId] =
    Codec.codecS[F, S, TenantUnitId]
end TenantUnitIdInstances
object TenantUnitIdInstances extends TenantUnitIdInstances
