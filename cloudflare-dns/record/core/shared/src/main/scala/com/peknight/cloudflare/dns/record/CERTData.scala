package com.peknight.cloudflare.dns.record

import cats.Show

case class CERTData(algorithm: Int, certificate: String, keyTag: Int, `type`: Int)
object CERTData:
  given showDNSRecordCERTData: Show[CERTData] = Show.fromToString[CERTData]
end CERTData
