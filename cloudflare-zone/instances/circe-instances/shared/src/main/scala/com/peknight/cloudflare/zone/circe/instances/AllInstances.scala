package com.peknight.cloudflare.zone.circe.instances

trait AllInstances extends ZoneIdInstances with AccountIdInstances with OwnerIdInstances with TenantIdInstances
with TenantUnitIdInstances with PlanIdInstances
object AllInstances extends AllInstances
