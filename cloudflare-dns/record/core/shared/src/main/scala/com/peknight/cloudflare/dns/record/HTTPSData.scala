package com.peknight.cloudflare.dns.record

import cats.Show

case class HTTPSData(priority: Int, target: String, value: String)
object HTTPSData:
  given showDNSRecordHTTPSData: Show[HTTPSData] = Show.fromToString[HTTPSData]
end HTTPSData
