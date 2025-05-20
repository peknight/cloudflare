package com.peknight.cloudflare.dns.record

import cats.Show

case class DNSKEYData(algorithm: Int, flags: Int, protocol: Int, publicKey: String)
object DNSKEYData:
  given showDNSRecordDNSKEYData: Show[DNSKEYData] = Show.fromToString[DNSKEYData]
end DNSKEYData
