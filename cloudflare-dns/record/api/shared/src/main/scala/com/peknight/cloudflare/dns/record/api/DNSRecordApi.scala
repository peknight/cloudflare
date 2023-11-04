package com.peknight.cloudflare.dns.record.api

import com.peknight.cloudflare.dns.record.DNSRecord
import com.peknight.cloudflare.zone.ZoneId
import com.peknight.cloudflare.{Result, Token}

trait DNSRecordApi[F[_]]:
  def listDNSRecords(zoneIdentifier: ZoneId)(token: Token): F[Result[List[DNSRecord]]]
end DNSRecordApi
