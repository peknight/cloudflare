package com.peknight.cloudflare.zone

import cats.{Monad, Show}
import com.comcast.ip4s.Hostname
import com.peknight.cloudflare.config.given
import com.peknight.codec.Codec
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.ip4s.instances.host.given
import com.peknight.codec.sum.*

case class Zone(
                 id: ZoneId,
                 name: String,
                 status: Option[ZoneStatus],
                 paused: Option[Boolean],
                 `type`: Option[String],
                 developmentMode: Int,
                 nameServers: Option[List[String]],
                 originalNameServers: List[Hostname],
                 originalRegistrar: String,
                 originalDnshost: Option[String],
                 modifiedOn: String,
                 createdOn: String,
                 activatedOn: String,
                 meta: ZoneMeta,
                 owner: Owner,
                 account: Account,
                 tenant: Option[Tenant],
                 tenantUnit: Option[TenantUnit],
                 permissions: Option[List[String]],
                 plan: Option[Plan],
                 vanityNameServers: Option[List[Hostname]]
               )
object Zone:
  given codecZone[F[_]: Monad, S: {ObjectType, NullType, ArrayType, NumberType, BooleanType, StringType, Show}]
  : Codec[F, S, Cursor[S], Zone] =
    Codec.derived[F, S, Zone]
end Zone
