package com.peknight.cloudflare.zone

import cats.{Monad, Show}
import com.peknight.cloudflare.config.given
import com.peknight.codec.Codec
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.sum.{NullType, ObjectType, StringType}

case class Tenant(id: Option[TenantId], name: Option[String])
object Tenant:
  given codecTenant[F[_]: Monad, S: {ObjectType, NullType, StringType, Show}]: Codec[F, S, Cursor[S], Tenant] =
    Codec.derived[F, S, Tenant]
end Tenant
