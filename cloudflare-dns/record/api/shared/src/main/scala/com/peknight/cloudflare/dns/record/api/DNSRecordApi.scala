package com.peknight.cloudflare.dns.record.api

import com.peknight.cloudflare.dns.record.body.DNSRecordBody
import com.peknight.cloudflare.dns.record.query.ListDNSRecordsQuery
import com.peknight.cloudflare.dns.record.{DNSRecord, DNSRecordId}
import com.peknight.cloudflare.zone.ZoneId
import com.peknight.cloudflare.{Result, Token}

trait DNSRecordApi[F[_]]:
  def listDNSRecords(zoneId: ZoneId)(query: ListDNSRecordsQuery)(token: Token): F[Result[List[DNSRecord]]]
  def createDNSRecord(zoneId: ZoneId)(body: DNSRecordBody)(token: Token): F[Result[DNSRecord]]
  def deleteDNSRecord(zoneId: ZoneId, dnsRecordId: DNSRecordId)(token: Token): F[Result[DNSRecordId]]
  def dnsRecordDetails(zoneId: ZoneId, dnsRecordId: DNSRecordId)(token: Token): F[Result[DNSRecord]]
  def updateDNSRecord(zoneId: ZoneId, dnsRecordId: DNSRecordId)(body: DNSRecordBody)(token: Token): F[Result[DNSRecord]]
  def overwriteDNSRecord(zoneId: ZoneId, dnsRecordId: DNSRecordId)(body: DNSRecordBody)(token: Token)
  : F[Result[DNSRecord]]
end DNSRecordApi
