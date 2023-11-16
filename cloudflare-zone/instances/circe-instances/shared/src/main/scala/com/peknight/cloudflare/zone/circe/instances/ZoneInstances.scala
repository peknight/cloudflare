package com.peknight.cloudflare.zone.circe.instances

import com.peknight.circe.instances.ip4s.HostInstances
import com.peknight.cloudflare.circe.instances.ConfigurationInstances
import com.peknight.cloudflare.zone.Zone
import com.peknight.codec.circe.derivation.CodecDerivation
import com.peknight.codec.circe.derivation.all.given
import io.circe.Codec
trait ZoneInstances extends ZoneIdInstances
  with AccountIdInstances
  with OwnerIdInstances
  with TenantIdInstances
  with TenantUnitIdInstances
  with PlanIdInstances
  with ZoneStatusInstances
  with HostInstances
  with ConfigurationInstances:
  given Codec[Zone] = CodecDerivation.derived
end ZoneInstances
object ZoneInstances extends ZoneInstances
