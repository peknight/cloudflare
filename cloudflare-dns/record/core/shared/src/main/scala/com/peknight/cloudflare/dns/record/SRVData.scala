package com.peknight.cloudflare.dns.record

import cats.Show
import com.comcast.ip4s.{Hostname, Port}

case class SRVData(port: Port, priority: Int, target: Hostname, weight: Int)
object SRVData:
  given showDNSRecordSRVData: Show[SRVData] = Show.fromToString[SRVData]
end SRVData
