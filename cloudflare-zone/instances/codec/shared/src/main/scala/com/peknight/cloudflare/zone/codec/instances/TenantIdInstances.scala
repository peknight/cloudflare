package com.peknight.cloudflare.zone.codec.instances

import cats.{Applicative, Show}
import com.peknight.cloudflare.zone.TenantId
import com.peknight.codec.Codec
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.sum.StringType

trait TenantIdInstances:
  given stringCodecTenantId[F[_]: Applicative]: Codec[F, String, String, TenantId] =
    Codec.map[F, String, String, TenantId](_.id)(TenantId.apply)

  given codecTenantIdS[F[_]: Applicative, S: {StringType, Show}]: Codec[F, S, Cursor[S], TenantId] =
    Codec.codecS[F, S, TenantId]
end TenantIdInstances
object TenantIdInstances extends TenantIdInstances
