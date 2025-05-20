package com.peknight.cloudflare.dns.record

import cats.Show

case class DNSRecordMeta(autoAdded: Option[Boolean], managedByApps: Option[Boolean],
                         managedByArgoTunnel: Option[Boolean], source: Option[String])
object DNSRecordMeta:
  given showDNSRecordMeta: Show[DNSRecordMeta] = Show.fromToString[DNSRecordMeta]
end DNSRecordMeta
