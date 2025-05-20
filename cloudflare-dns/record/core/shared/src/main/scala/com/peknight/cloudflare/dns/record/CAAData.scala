package com.peknight.cloudflare.dns.record

import cats.Show

case class CAAData(flags: Int, tag: String, value: String)
object CAAData:
  given showDNSRecordCAAData: Show[CAAData] = Show.fromToString[CAAData]
end CAAData
