package com.peknight.cloudflare.zone.circe.instances

import cats.Monad
import com.peknight.cloudflare.zone.*
import com.peknight.cloudflare.zone.codec.instances.all.given
import com.peknight.codec.Codec
import com.peknight.codec.circe.sum.jsonType.given
import com.peknight.codec.configuration.CodecConfiguration
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.ip4s.instances.host.given
import io.circe.Json

trait ZoneInstances:
  given codecZoneMeta[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], ZoneMeta] =
    Codec.derived[F, Json, ZoneMeta]

  given codecOwner[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], Owner] =
    Codec.derived[F, Json, Owner]

  given codecAccount[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], Account] =
    Codec.derived[F, Json, Account]

  given codecTenant[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], Tenant] =
    Codec.derived[F, Json, Tenant]

  given codecTenantUnit[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], TenantUnit] =
    Codec.derived[F, Json, TenantUnit]

  given codecPlan[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], Plan] =
    Codec.derived[F, Json, Plan]

  given codecZone[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], Zone] =
    Codec.derived[F, Json, Zone]
end ZoneInstances
object ZoneInstances extends ZoneInstances
