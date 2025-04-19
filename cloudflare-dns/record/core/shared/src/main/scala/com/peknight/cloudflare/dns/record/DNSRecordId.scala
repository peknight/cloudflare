package com.peknight.cloudflare.dns.record

import cats.{Eq, Show}

case class DNSRecordId(id: String) extends AnyVal
object DNSRecordId:
  given eqDNSRecordId: Eq[DNSRecordId] = Eq.fromUniversalEquals[DNSRecordId]
  given showDNSRecordId: Show[DNSRecordId] = Show.fromToString[DNSRecordId]
end DNSRecordId
