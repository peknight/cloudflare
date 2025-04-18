package com.peknight.cloudflare.zone.codec.instances

import cats.{Monad, Show}
import com.peknight.cloudflare.zone.TenantUnit
import com.peknight.cloudflare.zone.codec.instances.tenantUnitId.given
import com.peknight.codec.Codec
import com.peknight.codec.config.CodecConfig
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.sum.{NullType, ObjectType, StringType}

trait TenantUnitInstances:
  given codecTenantUnit[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], StringType[S], Show[S])
  : Codec[F, S, Cursor[S], TenantUnit] =
    Codec.derived[F, S, TenantUnit]
end TenantUnitInstances
object TenantUnitInstances extends TenantUnitInstances
