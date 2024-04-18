package com.peknight.cloudflare.zone.codec.instances

trait AllInstances extends AccountIdInstances
  with OwnerIdInstances
  with PlanIdInstances
  with TenantIdInstances
  with TenantUnitIdInstances
  with ZoneIdInstances
  with ZoneStatusInstances
object AllInstances extends AllInstances