package com.peknight.cloudflare.dns.record

case class DNSRecordMeta(autoAdded: Option[Boolean], managedByApps: Option[Boolean],
                         managedByArgoTunnel: Option[Boolean], source: Option[String])
