package com.peknight.cloudflare.dns.record.circe.instances

import com.peknight.cloudflare.dns.record.DNSRecordId
import io.circe.{Codec, Decoder, Encoder}

trait DNSRecordIdInstances:
  given Codec[DNSRecordId] = Codec.from(Decoder.decodeString.map(DNSRecordId.apply), Encoder.encodeString.contramap(_.id))
end DNSRecordIdInstances
object DNSRecordIdInstances extends DNSRecordIdInstances
