package com.peknight.cloudflare.dns.record

import cats.Show

case class SMIMEAData(certificate: String, matchingType: Int, selector: Int, usage: Int)
object SMIMEAData:
  given showDNSRecordSMIMEAData: Show[SMIMEAData] = Show.fromToString[SMIMEAData]
end SMIMEAData
