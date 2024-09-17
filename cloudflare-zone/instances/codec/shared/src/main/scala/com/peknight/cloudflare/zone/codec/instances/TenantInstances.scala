package com.peknight.cloudflare.zone.codec.instances

import cats.Monad
import com.peknight.cloudflare.zone.Tenant
import com.peknight.cloudflare.zone.codec.instances.tenantId.given
import com.peknight.codec.Codec
import com.peknight.codec.configuration.CodecConfiguration
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.sum.{NullType, ObjectType, StringType}

trait TenantInstances:
  given codecTenant[F[_], S](using CodecConfiguration, Monad[F], ObjectType[S], NullType[S], StringType[S])
  : Codec[F, S, Cursor[S], Tenant] =
    Codec.derived[F, S, Tenant]
end TenantInstances
object TenantInstances extends TenantInstances
