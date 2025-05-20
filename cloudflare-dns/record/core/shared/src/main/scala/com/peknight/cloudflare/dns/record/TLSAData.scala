package com.peknight.cloudflare.dns.record

import cats.Show

case class TLSAData(certificate: String, matchingType: Int, selector: Int, usage: Int)
object TLSAData:
  given showDNSRecordTLSAData: Show[TLSAData] = Show.fromToString[TLSAData]
end TLSAData
