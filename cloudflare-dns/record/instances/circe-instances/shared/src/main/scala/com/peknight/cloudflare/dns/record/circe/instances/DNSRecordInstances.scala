package com.peknight.cloudflare.dns.record.circe.instances

import com.peknight.circe.instances.ip4s.{HostInstances, PortInstances}
import com.peknight.cloudflare.circe.instances.ConfigurationInstances
import com.peknight.cloudflare.dns.record.DNSRecord
import com.peknight.cloudflare.zone.circe.instances.ZoneIdInstances
import com.peknight.codec.circe.derivation.CodecDerivation
import com.peknight.codec.circe.instances.all.given
import com.peknight.codec.configuration.CodecConfiguration
import com.peknight.commons.string.cases.SnakeCase
import com.peknight.commons.string.syntax.cases.to
import com.peknight.generic.Generic
import io.circe.{Codec, Encoder}

trait DNSRecordInstances extends DNSRecordIdInstances
  with DNSRecordTypeInstances
  with LatitudeDirectionInstances
  with LongitudeDirectionInstances
  with HostInstances
  with PortInstances
  with ZoneIdInstances
  with ConfigurationInstances:
  given Codec[DNSRecord] = CodecDerivation.derived(using configuration.withDiscriminator("type"))
end DNSRecordInstances
