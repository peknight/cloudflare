package com.peknight.cloudflare.zone.codec.instances

import cats.Monad
import com.peknight.cloudflare.zone.Zone
import com.peknight.cloudflare.zone.codec.instances.account.given
import com.peknight.cloudflare.zone.codec.instances.owner.given
import com.peknight.cloudflare.zone.codec.instances.plan.given
import com.peknight.cloudflare.zone.codec.instances.tenant.given
import com.peknight.cloudflare.zone.codec.instances.tenantUnit.given
import com.peknight.cloudflare.zone.codec.instances.zoneId.given
import com.peknight.cloudflare.zone.codec.instances.zoneMeta.given
import com.peknight.cloudflare.zone.codec.instances.zoneStatus.given
import com.peknight.codec.Codec
import com.peknight.codec.config.CodecConfig
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.ip4s.instances.host.given
import com.peknight.codec.sum.*

trait ZoneInstances:
  given codecZone[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                           NumberType[S], BooleanType[S], StringType[S]): Codec[F, S, Cursor[S], Zone] =
    Codec.derived[F, S, Zone]
end ZoneInstances
object ZoneInstances extends ZoneInstances
