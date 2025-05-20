package com.peknight.cloudflare.dns.record

import cats.Show

case class URIData(content: String, weight: Int)
object URIData:
  given showDNSRecordURIData: Show[URIData] = Show.fromToString[URIData]
end URIData
