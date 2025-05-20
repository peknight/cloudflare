package com.peknight.cloudflare.dns.record

import cats.Show

case class DSData(algorithm: Int, digest: String, digestType: Int, keyTag: Int)
object DSData:
  given showDNSRecordDSData: Show[DSData] = Show.fromToString[DSData]
end DSData
