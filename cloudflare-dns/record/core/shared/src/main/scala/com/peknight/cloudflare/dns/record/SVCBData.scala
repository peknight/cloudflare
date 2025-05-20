package com.peknight.cloudflare.dns.record

import cats.Show

case class SVCBData(priority: Int, target: String, value: String)
object SVCBData:
  given showDNSRecordSVCBData: Show[SVCBData] = Show.fromToString[SVCBData]
end SVCBData
