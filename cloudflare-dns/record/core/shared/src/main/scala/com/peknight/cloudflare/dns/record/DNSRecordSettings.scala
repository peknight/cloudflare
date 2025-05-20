package com.peknight.cloudflare.dns.record

import cats.Show

case class DNSRecordSettings(ipv4Only: Option[Boolean], ipv6Only: Option[Boolean])
object DNSRecordSettings:
  given showDNSRecordSettings: Show[DNSRecordSettings] = Show.fromToString[DNSRecordSettings]
end DNSRecordSettings
