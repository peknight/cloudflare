package com.peknight.cloudflare.dns.record

import cats.Eq

case class DNSRecordId(id: String) extends AnyVal
object DNSRecordId:
  given eqDNSRecordId: Eq[DNSRecordId] = Eq.fromUniversalEquals[DNSRecordId]
end DNSRecordId
