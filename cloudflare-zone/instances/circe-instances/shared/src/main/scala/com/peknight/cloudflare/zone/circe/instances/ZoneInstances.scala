package com.peknight.cloudflare.zone.circe.instances

import com.peknight.circe.instances.ip4s.HostInstances
import com.peknight.cloudflare.codec.instances.ConfigurationInstances
import com.peknight.cloudflare.zone.Zone
import com.peknight.cloudflare.zone.codec.instances.ZoneIdInstances
import com.peknight.codec.circe.iso.codec
import com.peknight.codec.circe.sum.JsonTypeInstances

import io.circe.Codec
trait ZoneInstances extends ZoneIdInstances
  with AccountIdInstances
  with OwnerIdInstances
  with TenantIdInstances
  with TenantUnitIdInstances
  with PlanIdInstances
  with ZoneStatusInstances
  with HostInstances
  with ConfigurationInstances
  with JsonTypeInstances:
  // given Codec[Zone] = codec[Zone]
end ZoneInstances
object ZoneInstances extends ZoneInstances
