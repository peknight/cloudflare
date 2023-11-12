package com.peknight.cloudflare.dns.record.circe.instances

import com.peknight.cloudflare.dns.record.DNSRecordType
import io.circe.Codec
import io.circe.derivation.{Configuration, ConfiguredEnumCodec}

trait DNSRecordTypeInstances:
  given Codec[DNSRecordType] = 
    ConfiguredEnumCodec.derived[DNSRecordType](using Configuration.default.withSnakeCaseMemberNames)
end DNSRecordTypeInstances
object DNSRecordTypeInstances extends DNSRecordTypeInstances
