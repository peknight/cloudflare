package com.peknight.cloudflare.dns.record.body

import cats.Show
import com.comcast.ip4s.{Hostname, Ipv4Address, Ipv6Address}
import com.peknight.cloudflare.dns.record.*

import scala.concurrent.duration.FiniteDuration

sealed trait DNSRecordBody:
  def name: String
  def `type`: DNSRecordType
  def comment: Option[String]
  def tags: Option[List[String]]
  def ttl: Option[FiniteDuration]
  def settings: Option[DNSRecordSettings]
end DNSRecordBody
object DNSRecordBody:
  case class A(content: Ipv4Address, name: String, proxied: Option[Boolean] = None, comment: Option[String] = None,
               tags: Option[List[String]] = None, ttl: Option[FiniteDuration] = None,
               settings: Option[DNSRecordSettings] = None) extends DNSRecordBody:
    def `type`: DNSRecordType = DNSRecordType.A
  end A

  case class AAAA(content: Ipv6Address, name: String, proxied: Option[Boolean] = None, comment: Option[String] = None,
                  tags: Option[List[String]] = None, ttl: Option[FiniteDuration] = None,
                  settings: Option[DNSRecordSettings] = None) extends DNSRecordBody:
    def `type`: DNSRecordType = DNSRecordType.AAAA
  end AAAA

  case class CAA(data: CAAData, name: String, comment: Option[String] = None, tags: Option[List[String]] = None,
                 ttl: Option[FiniteDuration] = None, settings: Option[DNSRecordSettings] = None) extends DNSRecordBody:
    def `type`: DNSRecordType = DNSRecordType.CAA
  end CAA

  case class CERT(data: CERTData, name: String, comment: Option[String] = None, tags: Option[List[String]] = None,
                  ttl: Option[FiniteDuration] = None, settings: Option[DNSRecordSettings] = None) extends DNSRecordBody:
    def `type`: DNSRecordType = DNSRecordType.CERT
  end CERT

  case class CNAME(content: Hostname, name: String, proxied: Option[Boolean] = None, comment: Option[String] = None,
                   tags: Option[List[String]] = None, ttl: Option[FiniteDuration] = None,
                   settings: Option[DNSRecordSettings] = None) extends DNSRecordBody:
    def `type`: DNSRecordType = DNSRecordType.CNAME
  end CNAME

  case class DNSKEY(data: DNSKEYData, name: String, comment: Option[String] = None, tags: Option[List[String]] = None,
                    ttl: Option[FiniteDuration] = None, settings: Option[DNSRecordSettings] = None) extends DNSRecordBody:
    def `type`: DNSRecordType = DNSRecordType.DNSKEY
  end DNSKEY

  case class DS(data: DSData, name: String, comment: Option[String] = None, tags: Option[List[String]] = None,
                ttl: Option[FiniteDuration] = None, settings: Option[DNSRecordSettings] = None) extends DNSRecordBody:
    def `type`: DNSRecordType = DNSRecordType.DS
  end DS
  case class HTTPS(data: HTTPSData, name: String, comment: Option[String] = None, tags: Option[List[String]] = None,
                   ttl: Option[FiniteDuration] = None, settings: Option[DNSRecordSettings] = None) extends DNSRecordBody:
    def `type`: DNSRecordType = DNSRecordType.HTTPS
  end HTTPS
  case class LOC(data: LOCData, name: String, comment: Option[String] = None, tags: Option[List[String]] = None,
                 ttl: Option[FiniteDuration] = None, settings: Option[DNSRecordSettings] = None) extends DNSRecordBody:
    def `type`: DNSRecordType = DNSRecordType.LOC
  end LOC
  case class MX(content: Hostname, name: String, priority: Int, comment: Option[String] = None,
                tags: Option[List[String]] = None, ttl: Option[FiniteDuration] = None,
                settings: Option[DNSRecordSettings] = None) extends DNSRecordBody:
    def `type`: DNSRecordType = DNSRecordType.MX
  end MX
  case class NAPTR(data: NAPTRData, name: String, comment: Option[String] = None, tags: Option[List[String]] = None,
                   ttl: Option[FiniteDuration] = None, settings: Option[DNSRecordSettings] = None) extends DNSRecordBody:
    def `type`: DNSRecordType = DNSRecordType.NAPTR
  end NAPTR
  case class NS(content: Hostname, name: String, comment: Option[String] = None, tags: Option[List[String]] = None,
                ttl: Option[FiniteDuration] = None, settings: Option[DNSRecordSettings] = None) extends DNSRecordBody:
    def `type`: DNSRecordType = DNSRecordType.NS
  end NS
  case class OPENPGPKEY(content: String, name: String, proxied: Option[Boolean], comment: Option[String] = None,
                        tags: Option[List[String]] = None, ttl: Option[FiniteDuration] = None,
                        settings: Option[DNSRecordSettings] = None) extends DNSRecordBody:
    def `type`: DNSRecordType = DNSRecordType.OPENPGPKEY
  end OPENPGPKEY
  case class PTR(content: String, name: String, comment: Option[String] = None, tags: Option[List[String]] = None,
                 ttl: Option[FiniteDuration] = None, settings: Option[DNSRecordSettings] = None) extends DNSRecordBody:
    def `type`: DNSRecordType = DNSRecordType.PTR
  end PTR
  case class SMIMEA(data: SMIMEAData, name: String, comment: Option[String] = None, tags: Option[List[String]] = None,
                    ttl: Option[FiniteDuration] = None, settings: Option[DNSRecordSettings] = None) extends DNSRecordBody:
    def `type`: DNSRecordType = DNSRecordType.SMIMEA
  end SMIMEA
  case class SRV(data: SRVData, name: String, comment: Option[String] = None, tags: Option[List[String]] = None,
                 ttl: Option[FiniteDuration] = None, settings: Option[DNSRecordSettings] = None) extends DNSRecordBody:
    def `type`: DNSRecordType = DNSRecordType.SRV
  end SRV
  case class SSHFP(data: SSHFPData, name: String, comment: Option[String] = None, tags: Option[List[String]] = None,
                   ttl: Option[FiniteDuration] = None, settings: Option[DNSRecordSettings] = None) extends DNSRecordBody:
    def `type`: DNSRecordType = DNSRecordType.SSHFP
  end SSHFP
  case class SVCB(data: SVCBData, name: String, comment: Option[String] = None, tags: Option[List[String]] = None,
                  ttl: Option[FiniteDuration] = None,
                   settings: Option[DNSRecordSettings] = None) extends DNSRecordBody:
    def `type`: DNSRecordType = DNSRecordType.SVCB
  end SVCB
  case class TLSA(data: TLSAData, name: String, comment: Option[String] = None, tags: Option[List[String]] = None,
                  ttl: Option[FiniteDuration] = None, settings: Option[DNSRecordSettings] = None) extends DNSRecordBody:
    def `type`: DNSRecordType = DNSRecordType.TLSA
  end TLSA
  case class TXT(content: String, name: String, comment: Option[String] = None, tags: Option[List[String]] = None,
                 ttl: Option[FiniteDuration] = None, settings: Option[DNSRecordSettings] = None) extends DNSRecordBody:
    def `type`: DNSRecordType = DNSRecordType.TXT
  end TXT
  case class URI(data: URIData, name: String, priority: Int, comment: Option[String] = None,
                 tags: Option[List[String]] = None, ttl: Option[FiniteDuration] = None,
                 settings: Option[DNSRecordSettings] = None) extends DNSRecordBody:
    def `type`: DNSRecordType = DNSRecordType.URI
  end URI
  given showDNSRecordBodyA: Show[A] = Show.fromToString[A]
  given showDNSRecordBodyAAAA: Show[AAAA] = Show.fromToString[AAAA]
  given showDNSRecordBodyCAA: Show[CAA] = Show.fromToString[CAA]
  given showDNSRecordBodyCERT: Show[CERT] = Show.fromToString[CERT]
  given showDNSRecordBodyCNAME: Show[CNAME] = Show.fromToString[CNAME]
  given showDNSRecordBodyDNSKEY: Show[DNSKEY] = Show.fromToString[DNSKEY]
  given showDNSRecordBodyDS: Show[DS] = Show.fromToString[DS]
  given showDNSRecordBodyHTTPS: Show[HTTPS] = Show.fromToString[HTTPS]
  given showDNSRecordBodyLOC: Show[LOC] = Show.fromToString[LOC]
  given showDNSRecordBodyMX: Show[MX] = Show.fromToString[MX]
  given showDNSRecordBodyNAPTR: Show[NAPTR] = Show.fromToString[NAPTR]
  given showDNSRecordBodyNS: Show[NS] = Show.fromToString[NS]
  given showDNSRecordBodyOPENPGPKEY: Show[OPENPGPKEY] = Show.fromToString[OPENPGPKEY]
  given showDPTRRecordBodyPTR: Show[PTR] = Show.fromToString[PTR]
  given showDSMIMEARecordBodySMIMEA: Show[SMIMEA] = Show.fromToString[SMIMEA]
  given showDSRVRecordBodySRV: Show[SRV] = Show.fromToString[SRV]
  given showDSSHFPRecordBodySSHFP: Show[SSHFP] = Show.fromToString[SSHFP]
  given showDSVCBRecordBodySVCB: Show[SVCB] = Show.fromToString[SVCB]
  given showDTLSARecordBodyTLSA: Show[TLSA] = Show.fromToString[TLSA]
  given showDTXTRecordBodyTXT: Show[TXT] = Show.fromToString[TXT]
  given showDNSRecordBodyURI: Show[URI] = Show.fromToString[URI]
  given showDNSRecordBody: Show[DNSRecordBody] = Show.fromToString[DNSRecordBody]
end DNSRecordBody
