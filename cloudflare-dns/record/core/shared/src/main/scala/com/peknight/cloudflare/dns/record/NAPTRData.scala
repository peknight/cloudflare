package com.peknight.cloudflare.dns.record

import cats.Show

case class NAPTRData(flags: String, order: Int, preference: Int, regex: String, replacement: String, service: String)
object NAPTRData:
  given showDNSRecordNAPTRData: Show[NAPTRData] = Show.fromToString[NAPTRData]
end NAPTRData
