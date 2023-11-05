package com.peknight.cloudflare.zone.circe.instances

import com.peknight.circe.instances.ip4s.HostInstances
import com.peknight.cloudflare.circe.instances.configuration.configuration
import com.peknight.cloudflare.zone.Zone
import com.peknight.generic.circe.CodecInstances
import com.peknight.generic.circe.all.given
import io.circe.Codec
trait ZoneInstances extends ZoneIdInstances
  with AccountIdInstances
  with OwnerIdInstances
  with TenantIdInstances
  with TenantUnitIdInstances
  with PlanIdInstances
  with ZoneStatusInstances
  with HostInstances:
  given Codec[Zone] = CodecInstances.derivedConfiguredCodec(configuration)
end ZoneInstances
object ZoneInstances extends ZoneInstances
