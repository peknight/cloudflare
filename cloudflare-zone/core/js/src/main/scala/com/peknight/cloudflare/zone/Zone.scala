package com.peknight.cloudflare.zone

import com.comcast.ip4s.Hostname

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
