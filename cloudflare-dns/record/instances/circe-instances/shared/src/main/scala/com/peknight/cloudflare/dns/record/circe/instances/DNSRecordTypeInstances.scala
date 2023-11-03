package com.peknight.cloudflare.dns.record.circe.instances

import com.peknight.cloudflare.circe.instances.configuration.given
import com.peknight.cloudflare.dns.record.DNSRecordType
import io.circe.Codec
import io.circe.derivation.ConfiguredEnumCodec

trait DNSRecordTypeInstances:
  given Codec[DNSRecordType] = ConfiguredEnumCodec.derived[DNSRecordType]
end DNSRecordTypeInstances
object DNSRecordTypeInstances extends DNSRecordTypeInstances
