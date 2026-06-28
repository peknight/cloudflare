package com.peknight.cloudflare.dns.record.body

import cats.{Monad, Show}
import com.comcast.ip4s.{Hostname, Ipv4Address, Ipv6Address}
import com.peknight.cloudflare.config.given
import com.peknight.cloudflare.dns.record.*
import com.peknight.cloudflare.dns.record.body.DNSRecordBody.*
import com.peknight.codec.Codec
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.instances.time.finiteDuration.codecFiniteDurationOfSecondsNS
import com.peknight.codec.ip4s.instances.host.given
import com.peknight.codec.sum.*

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

  given codecDNSRecordBodyA[F[_]: Monad, S: {ObjectType, NullType, ArrayType, NumberType, BooleanType, StringType, Show}]
  : Codec[F, S, Cursor[S], A] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, A]
  given codecDNSRecordBodyAAAA[F[_]: Monad, S: {ObjectType, NullType, ArrayType, NumberType, BooleanType, StringType, Show}]
  : Codec[F, S, Cursor[S], AAAA] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, AAAA]
  given codecDNSRecordBodyCAA[F[_]: Monad, S: {ObjectType, NullType, ArrayType, NumberType, BooleanType, StringType, Show}]
  : Codec[F, S, Cursor[S], CAA] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, CAA]
  given codecDNSRecordBodyCERT[F[_]: Monad, S: {ObjectType, NullType, ArrayType, NumberType, BooleanType, StringType, Show}]
  : Codec[F, S, Cursor[S], CERT] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, CERT]
  given codecDNSRecordBodyCNAME[F[_]: Monad, S: {ObjectType, NullType, ArrayType, NumberType, BooleanType, StringType, Show}]
  : Codec[F, S, Cursor[S], CNAME] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, CNAME]
  given codecDNSRecordBodyDNSKEY[F[_]: Monad, S: {ObjectType, NullType, ArrayType, NumberType, BooleanType, StringType, Show}]
  : Codec[F, S, Cursor[S], DNSKEY] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, DNSKEY]
  given codecDNSRecordBodyDS[F[_]: Monad, S: {ObjectType, NullType, ArrayType, NumberType, BooleanType, StringType, Show}]
  : Codec[F, S, Cursor[S], DS] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, DS]
  given codecDNSRecordBodyHTTPS[F[_]: Monad, S: {ObjectType, NullType, ArrayType, NumberType, BooleanType, StringType, Show}]
  : Codec[F, S, Cursor[S], HTTPS] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, HTTPS]
  given codecDNSRecordBodyLOC[F[_]: Monad, S: {ObjectType, NullType, ArrayType, NumberType, BooleanType, StringType, Show}]
  : Codec[F, S, Cursor[S], LOC] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, LOC]
  given codecDNSRecordBodyMX[F[_]: Monad, S: {ObjectType, NullType, ArrayType, NumberType, BooleanType, StringType, Show}]
  : Codec[F, S, Cursor[S], MX] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, MX]
  given codecDNSRecordBodyNAPTR[F[_]: Monad, S: {ObjectType, NullType, ArrayType, NumberType, BooleanType, StringType, Show}]
  : Codec[F, S, Cursor[S], NAPTR] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, NAPTR]
  given codecDNSRecordBodyNS[F[_]: Monad, S: {ObjectType, NullType, ArrayType, NumberType, BooleanType, StringType, Show}]
  : Codec[F, S, Cursor[S], NS] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, NS]
  given codecDNSRecordBodyOPENPGPKEY[F[_]: Monad, S: {ObjectType, NullType, ArrayType, NumberType, BooleanType, StringType, Show}]
  : Codec[F, S, Cursor[S], OPENPGPKEY] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, OPENPGPKEY]
  given codecDNSRecordBodyPTR[F[_]: Monad, S: {ObjectType, NullType, ArrayType, NumberType, BooleanType, StringType, Show}]
  : Codec[F, S, Cursor[S], PTR] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, PTR]
  given codecDNSRecordBodySMIMEA[F[_]: Monad, S: {ObjectType, NullType, ArrayType, NumberType, BooleanType, StringType, Show}]
  : Codec[F, S, Cursor[S], SMIMEA] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, SMIMEA]
  given codecDNSRecordBodySRV[F[_]: Monad, S: {ObjectType, NullType, ArrayType, NumberType, BooleanType, StringType, Show}]
  : Codec[F, S, Cursor[S], SRV] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, SRV]
  given codecDNSRecordBodySSHFP[F[_]: Monad, S: {ObjectType, NullType, ArrayType, NumberType, BooleanType, StringType, Show}]
  : Codec[F, S, Cursor[S], SSHFP] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, SSHFP]
  given codecDNSRecordBodySVCB[F[_]: Monad, S: {ObjectType, NullType, ArrayType, NumberType, BooleanType, StringType, Show}]
  : Codec[F, S, Cursor[S], SVCB] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, SVCB]
  given codecDNSRecordBodyTLSA[F[_]: Monad, S: {ObjectType, NullType, ArrayType, NumberType, BooleanType, StringType, Show}]
  : Codec[F, S, Cursor[S], TLSA] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, TLSA]
  given codecDNSRecordBodyTXT[F[_]: Monad, S: {ObjectType, NullType, ArrayType, NumberType, BooleanType, StringType, Show}]
  : Codec[F, S, Cursor[S], TXT] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, TXT]
  given codecDNSRecordBodyURI[F[_]: Monad, S: {ObjectType, NullType, ArrayType, NumberType, BooleanType, StringType, Show}]
  : Codec[F, S, Cursor[S], URI] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, URI]
  given codecDNSRecordBody[F[_]: Monad, S: {ObjectType, NullType, ArrayType, NumberType, BooleanType, StringType, Show}]
  : Codec[F, S, Cursor[S], DNSRecordBody] =
    Codec.derived[F, S, DNSRecordBody](using codecConfig.withDiscriminator("type"))

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
