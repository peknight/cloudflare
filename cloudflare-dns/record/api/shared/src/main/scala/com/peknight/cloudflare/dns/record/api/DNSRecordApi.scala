package com.peknight.cloudflare.dns.record.api

import com.peknight.cloudflare.Result
import com.peknight.cloudflare.dns.record.body.DNSRecordBody
import com.peknight.cloudflare.dns.record.query.ListDNSRecordsQuery
import com.peknight.cloudflare.dns.record.{DNSRecord, DNSRecordId}
import com.peknight.cloudflare.zone.ZoneId

trait DNSRecordApi[F[_]]:
  def listDNSRecords(zoneId: ZoneId)(query: ListDNSRecordsQuery): F[Result[List[DNSRecord]]]
  def createDNSRecord(zoneId: ZoneId)(body: DNSRecordBody): F[Result[DNSRecord]]
  def deleteDNSRecord(zoneId: ZoneId, dnsRecordId: DNSRecordId): F[Result[DNSRecordId]]
  def dnsRecordDetails(zoneId: ZoneId, dnsRecordId: DNSRecordId): F[Result[DNSRecord]]
  def updateDNSRecord(zoneId: ZoneId, dnsRecordId: DNSRecordId)(body: DNSRecordBody): F[Result[DNSRecord]]
  def overwriteDNSRecord(zoneId: ZoneId, dnsRecordId: DNSRecordId)(body: DNSRecordBody): F[Result[DNSRecord]]
end DNSRecordApi
