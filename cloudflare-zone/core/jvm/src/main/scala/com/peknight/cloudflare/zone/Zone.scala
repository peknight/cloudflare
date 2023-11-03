package com.peknight.cloudflare.zone

import java.time.OffsetDateTime

case class Zone(
                 id: ZoneId,
                 name: String,
                 status: Option[String],
                 paused: Option[Boolean],
                 `type`: Option[String],
                 developmentMode: Int,
                 nameServers: Option[List[String]],
                 originalNameServers: List[String],
                 originalRegistrar: String,
                 originalDnshost: Option[String],
                 modifiedOn: OffsetDateTime,
                 createdOn: OffsetDateTime,
                 activatedOn: OffsetDateTime,
                 meta: ZoneMeta,
                 owner: Owner,
                 account: Account,
                 tenant: Option[Tenant],
                 tenantUnit: Option[TenantUnit],
                 permissions: Option[List[String]],
                 plan: Option[Plan],
                 vanityNameServers: Option[List[String]]
               )
