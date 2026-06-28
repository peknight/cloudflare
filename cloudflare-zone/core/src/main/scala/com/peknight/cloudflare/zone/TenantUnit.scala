package com.peknight.cloudflare.zone

import cats.{Monad, Show}
import com.peknight.cloudflare.config.given
import com.peknight.codec.Codec
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.sum.{NullType, ObjectType, StringType}

case class TenantUnit(id: Option[TenantUnitId])
object TenantUnit:
  given codecTenantUnit[F[_]: Monad, S: {ObjectType, NullType, StringType, Show}]: Codec[F, S, Cursor[S], TenantUnit] =
    Codec.derived[F, S, TenantUnit]
end TenantUnit

