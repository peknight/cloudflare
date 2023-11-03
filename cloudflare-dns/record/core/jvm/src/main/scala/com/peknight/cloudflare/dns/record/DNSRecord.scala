package com.peknight.cloudflare.dns.record

import com.comcast.ip4s.{Host, Hostname, Ipv4Address, Ipv6Address}
import com.peknight.cloudflare.zone.ZoneId

import java.time.OffsetDateTime

sealed trait DNSRecord:
  type CONTENT <: Host | String
  def id: DNSRecordId
  def zoneId: Option[ZoneId]
  def zoneName: String
  def name: String
  def `type`: DNSRecordType
  def content: CONTENT
  def proxiable: Boolean
  def proxied: Option[Boolean]
  def ttl: Option[Int]
  def locked: Boolean
  def meta: Option[DNSRecordMeta]
  def comment: Option[String]
  def tags: Option[List[String]]
  def createdOn: OffsetDateTime
  def modifiedOn: OffsetDateTime
end DNSRecord
object DNSRecord:
  case class A(
                id: DNSRecordId, zoneId: Option[ZoneId], zoneName: String, name: String, content: Ipv4Address,
                proxiable: Boolean, proxied: Option[Boolean], ttl: Option[Int], locked: Boolean,
                meta: Option[DNSRecordMeta], comment: Option[String], tags: Option[List[String]],
                createdOn: OffsetDateTime, modifiedOn: OffsetDateTime
              ) extends DNSRecord:
    type CONTENT = Ipv4Address
    def `type`: DNSRecordType = DNSRecordType.A
  end A

  case class AAAA(
                   id: DNSRecordId, zoneId: Option[ZoneId], zoneName: String, name: String, content: Ipv6Address,
                   proxiable: Boolean, proxied: Option[Boolean], ttl: Option[Int], locked: Boolean,
                   meta: Option[DNSRecordMeta], comment: Option[String], tags: Option[List[String]],
                   createdOn: OffsetDateTime, modifiedOn: OffsetDateTime
                 ) extends DNSRecord:
    type CONTENT = Ipv6Address
    def `type`: DNSRecordType = DNSRecordType.AAAA
  end AAAA

  case class CAA(
                   id: DNSRecordId, zoneId: Option[ZoneId], zoneName: String, name: String, content: String,
                   data: CAAData, proxiable: Boolean, proxied: Option[Boolean], ttl: Option[Int], locked: Boolean,
                   meta: Option[DNSRecordMeta], comment: Option[String], tags: Option[List[String]],
                   createdOn: OffsetDateTime, modifiedOn: OffsetDateTime
                 ) extends DNSRecord:
    type CONTENT = String
    def `type`: DNSRecordType = DNSRecordType.CAA
  end CAA

  case class CERT(
                  id: DNSRecordId, zoneId: Option[ZoneId], zoneName: String, name: String, content: String,
                  data: CERTData, proxiable: Boolean, proxied: Option[Boolean], ttl: Option[Int], locked: Boolean,
                  meta: Option[DNSRecordMeta], comment: Option[String], tags: Option[List[String]],
                  createdOn: OffsetDateTime, modifiedOn: OffsetDateTime
                ) extends DNSRecord:
    type CONTENT = String
    def `type`: DNSRecordType = DNSRecordType.CERT
  end CERT

  case class CNAME(
                   id: DNSRecordId, zoneId: Option[ZoneId], zoneName: String, name: String, content: String,
                   proxiable: Boolean, proxied: Option[Boolean], ttl: Option[Int], locked: Boolean,
                   meta: Option[DNSRecordMeta], comment: Option[String], tags: Option[List[String]],
                   createdOn: OffsetDateTime, modifiedOn: OffsetDateTime
                 ) extends DNSRecord:
    type CONTENT = String
    def `type`: DNSRecordType = DNSRecordType.CNAME
  end CNAME

  case class DNSKEY(
                   id: DNSRecordId, zoneId: Option[ZoneId], zoneName: String, name: String, content: String,
                   data: DNSKEYData, proxiable: Boolean, proxied: Option[Boolean], ttl: Option[Int], locked: Boolean,
                   meta: Option[DNSRecordMeta], comment: Option[String], tags: Option[List[String]],
                   createdOn: OffsetDateTime, modifiedOn: OffsetDateTime
                 ) extends DNSRecord:
    type CONTENT = String
    def `type`: DNSRecordType = DNSRecordType.DNSKEY
  end DNSKEY

  case class DS(
                 id: DNSRecordId, zoneId: Option[ZoneId], zoneName: String, name: String, content: String,
                 data: DSData, proxiable: Boolean, proxied: Option[Boolean], ttl: Option[Int], locked: Boolean,
                 meta: Option[DNSRecordMeta], comment: Option[String], tags: Option[List[String]],
                 createdOn: OffsetDateTime, modifiedOn: OffsetDateTime
               ) extends DNSRecord:
    type CONTENT = String
    def `type`: DNSRecordType = DNSRecordType.DS
  end DS

  case class HTTPS(
                    id: DNSRecordId, zoneId: Option[ZoneId], zoneName: String, name: String, content: String,
                    data: HTTPSData, proxiable: Boolean, proxied: Option[Boolean], ttl: Option[Int], locked: Boolean,
                    meta: Option[DNSRecordMeta], comment: Option[String], tags: Option[List[String]],
                    createdOn: OffsetDateTime, modifiedOn: OffsetDateTime
                  ) extends DNSRecord:
    type CONTENT = String
    def `type`: DNSRecordType = DNSRecordType.HTTPS
  end HTTPS

  case class LOC(
                  id: DNSRecordId, zoneId: Option[ZoneId], zoneName: String, name: String, content: String,
                  data: LOCData, proxiable: Boolean, proxied: Option[Boolean], ttl: Option[Int], locked: Boolean,
                  meta: Option[DNSRecordMeta], comment: Option[String], tags: Option[List[String]],
                  createdOn: OffsetDateTime, modifiedOn: OffsetDateTime
                ) extends DNSRecord:
    type CONTENT = String
    def `type`: DNSRecordType = DNSRecordType.LOC
  end LOC

  case class MX(
                   id: DNSRecordId, zoneId: Option[ZoneId], zoneName: String, name: String, content: Hostname,
                   proxiable: Boolean, proxied: Option[Boolean], ttl: Option[Int], locked: Boolean,
                   meta: Option[DNSRecordMeta], comment: Option[String], tags: Option[List[String]],
                   createdOn: OffsetDateTime, modifiedOn: OffsetDateTime
                 ) extends DNSRecord:
    type CONTENT = Hostname
    def `type`: DNSRecordType = DNSRecordType.MX
  end MX

  case class NAPTR(
                    id: DNSRecordId, zoneId: Option[ZoneId], zoneName: String, name: String, content: String,
                    data: NAPTRData, proxiable: Boolean, proxied: Option[Boolean], ttl: Option[Int], locked: Boolean,
                    meta: Option[DNSRecordMeta], comment: Option[String], tags: Option[List[String]],
                    createdOn: OffsetDateTime, modifiedOn: OffsetDateTime
                  ) extends DNSRecord:
    type CONTENT = String
    def `type`: DNSRecordType = DNSRecordType.NAPTR
  end NAPTR

  case class NS(
                 id: DNSRecordId, zoneId: Option[ZoneId], zoneName: String, name: String, content: String,
                 proxiable: Boolean, proxied: Option[Boolean], ttl: Option[Int], locked: Boolean,
                 meta: Option[DNSRecordMeta], comment: Option[String], tags: Option[List[String]],
                 createdOn: OffsetDateTime, modifiedOn: OffsetDateTime
               ) extends DNSRecord:
    type CONTENT = String
    def `type`: DNSRecordType = DNSRecordType.NS
  end NS

  case class PTR(
                  id: DNSRecordId, zoneId: Option[ZoneId], zoneName: String, name: String, content: String,
                  proxiable: Boolean, proxied: Option[Boolean], ttl: Option[Int], locked: Boolean,
                  meta: Option[DNSRecordMeta], comment: Option[String], tags: Option[List[String]],
                  createdOn: OffsetDateTime, modifiedOn: OffsetDateTime
                ) extends DNSRecord:
    type CONTENT = String
    def `type`: DNSRecordType = DNSRecordType.PTR
  end PTR

  case class SMIMEA(
                     id: DNSRecordId, zoneId: Option[ZoneId], zoneName: String, name: String, content: String,
                     data: SMIMEAData, proxiable: Boolean, proxied: Option[Boolean], ttl: Option[Int], locked: Boolean,
                     meta: Option[DNSRecordMeta], comment: Option[String], tags: Option[List[String]],
                     createdOn: OffsetDateTime, modifiedOn: OffsetDateTime
                   ) extends DNSRecord:
    type CONTENT = String
    def `type`: DNSRecordType = DNSRecordType.SMIMEA
  end SMIMEA

  case class SRV(
                  id: DNSRecordId, zoneId: Option[ZoneId], zoneName: String, name: String, content: String,
                  data: SRVData, proxiable: Boolean, proxied: Option[Boolean], ttl: Option[Int], locked: Boolean,
                  meta: Option[DNSRecordMeta], comment: Option[String], tags: Option[List[String]],
                  createdOn: OffsetDateTime, modifiedOn: OffsetDateTime
                ) extends DNSRecord:
    type CONTENT = String
    def `type`: DNSRecordType = DNSRecordType.SRV
  end SRV

  case class SSHFP(
                    id: DNSRecordId, zoneId: Option[ZoneId], zoneName: String, name: String, content: String,
                    data: SSHFPData, proxiable: Boolean, proxied: Option[Boolean], ttl: Option[Int], locked: Boolean,
                    meta: Option[DNSRecordMeta], comment: Option[String], tags: Option[List[String]],
                    createdOn: OffsetDateTime, modifiedOn: OffsetDateTime
                  ) extends DNSRecord:
    type CONTENT = String
    def `type`: DNSRecordType = DNSRecordType.SSHFP
  end SSHFP

  case class SVCB(
                   id: DNSRecordId, zoneId: Option[ZoneId], zoneName: String, name: String, content: String,
                   data: SVCBData, proxiable: Boolean, proxied: Option[Boolean], ttl: Option[Int], locked: Boolean,
                   meta: Option[DNSRecordMeta], comment: Option[String], tags: Option[List[String]],
                   createdOn: OffsetDateTime, modifiedOn: OffsetDateTime
                 ) extends DNSRecord:
    type CONTENT = String
    def `type`: DNSRecordType = DNSRecordType.SVCB
  end SVCB

  case class TLSA(
                   id: DNSRecordId, zoneId: Option[ZoneId], zoneName: String, name: String, content: String,
                   data: TLSAData, proxiable: Boolean, proxied: Option[Boolean], ttl: Option[Int], locked: Boolean,
                   meta: Option[DNSRecordMeta], comment: Option[String], tags: Option[List[String]],
                   createdOn: OffsetDateTime, modifiedOn: OffsetDateTime
                 ) extends DNSRecord:
    type CONTENT = String
    def `type`: DNSRecordType = DNSRecordType.TLSA
  end TLSA

  case class TXT(
                  id: DNSRecordId, zoneId: Option[ZoneId], zoneName: String, name: String, content: String,
                  proxiable: Boolean, proxied: Option[Boolean], ttl: Option[Int], locked: Boolean,
                  meta: Option[DNSRecordMeta], comment: Option[String], tags: Option[List[String]],
                  createdOn: OffsetDateTime, modifiedOn: OffsetDateTime
                ) extends DNSRecord:
    type CONTENT = String
    def `type`: DNSRecordType = DNSRecordType.TXT
  end TXT

  case class URI(
                   id: DNSRecordId, zoneId: Option[ZoneId], zoneName: String, name: String, content: String,
                   data: URIData, proxiable: Boolean, proxied: Option[Boolean], ttl: Option[Int], locked: Boolean,
                   meta: Option[DNSRecordMeta], comment: Option[String], tags: Option[List[String]],
                   createdOn: OffsetDateTime, modifiedOn: OffsetDateTime
                 ) extends DNSRecord:
    type CONTENT = String
    def `type`: DNSRecordType = DNSRecordType.URI
  end URI
end DNSRecord
