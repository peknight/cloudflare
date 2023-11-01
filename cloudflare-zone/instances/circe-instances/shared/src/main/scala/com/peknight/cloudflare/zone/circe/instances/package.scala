package com.peknight.cloudflare.zone.circe

package object instances:
  object all extends ZoneIdInstances with AccountIdInstances with OwnerIdInstances with TenantIdInstances
    with TenantUnitIdInstances with PlanIdInstances
  object zoneId extends ZoneIdInstances
  object accountId extends AccountIdInstances
  object ownerId extends OwnerIdInstances
  object tenantId extends TenantIdInstances
  object tenantUnitId extends TenantUnitIdInstances
  object planId extends PlanIdInstances
end instances
