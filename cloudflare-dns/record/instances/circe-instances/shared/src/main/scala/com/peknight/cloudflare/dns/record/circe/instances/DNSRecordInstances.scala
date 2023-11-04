package com.peknight.cloudflare.dns.record.circe.instances

import com.peknight.circe.instances.ip4s.{HostInstances, PortInstances}
import com.peknight.cloudflare.circe.instances.configuration.configuration
import com.peknight.cloudflare.dns.record.DNSRecord
import com.peknight.cloudflare.zone.circe.instances.ZoneIdInstances
import com.peknight.generic.circe.CodecInstances
import com.peknight.generic.circe.all.given
import io.circe.Codec
import io.circe.derivation.Configuration

trait DNSRecordInstances extends DNSRecordIdInstances
  with DNSRecordTypeInstances
  with LatitudeDirectionInstances
  with LongitudeDirectionInstances
  with HostInstances
  with PortInstances
  with ZoneIdInstances:
  given Configuration = configuration
  given Codec[DNSRecord] = CodecInstances.derivedConfiguredCodec(configuration.withDiscriminator("type"))

end DNSRecordInstances
