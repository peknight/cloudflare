package com.peknight.cloudflare.dns.record.codec.instances

import cats.syntax.contravariant.*
import cats.{Monad, Show}
import com.comcast.ip4s.{Host, Hostname, Ipv4Address, Ipv6Address}
import com.peknight.cats.instances.time.instant.given
import com.peknight.cloudflare.dns.record.DNSRecord
import com.peknight.cloudflare.dns.record.DNSRecord.*
import com.peknight.cloudflare.dns.record.codec.instances.dnsRecordData.given
import com.peknight.cloudflare.dns.record.codec.instances.dnsRecordId.given
import com.peknight.cloudflare.dns.record.codec.instances.dnsRecordMeta.given
import com.peknight.cloudflare.dns.record.codec.instances.dnsRecordSettings.given
import com.peknight.cloudflare.zone.codec.instances.zoneId.given
import com.peknight.codec.Codec
import com.peknight.codec.config.CodecConfig
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.instances.time.finiteDuration.codecFiniteDurationOfSecondsNS
import com.peknight.codec.ip4s.instances.host.given
import com.peknight.codec.sum.*
import com.peknight.generic.derivation.show

import scala.concurrent.duration.FiniteDuration

//noinspection DuplicatedCode
trait DNSRecordInstances:

  given codecDNSRecordA[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                 NumberType[S], BooleanType[S], StringType[S], Show[S]): Codec[F, S, Cursor[S], A] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, A]
  given showDNSRecordA: Show[A] =
    given Show[Ipv4Address] = Show[Host].contramap[Ipv4Address](identity)
    show.derived[A]
  given codecDNSRecordAAAA[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                    NumberType[S], BooleanType[S], StringType[S], Show[S]): Codec[F, S, Cursor[S], AAAA] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, AAAA]
  given showDNSRecordAAAA: Show[AAAA] =
    given Show[Ipv6Address] = Show[Host].contramap[Ipv6Address](identity)
    show.derived[AAAA]
  given codecDNSRecordCAA[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                   NumberType[S], BooleanType[S], StringType[S], Show[S]): Codec[F, S, Cursor[S], CAA] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, CAA]
  given showDNSRecordCAA: Show[CAA] = show.derived[CAA]
  given codecDNSRecordCERT[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                    NumberType[S], BooleanType[S], StringType[S], Show[S]): Codec[F, S, Cursor[S], CERT] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, CERT]
  given showDNSRecordCERT: Show[CERT] = show.derived[CERT]
  given codecDNSRecordCNAME[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                     NumberType[S], BooleanType[S], StringType[S], Show[S]): Codec[F, S, Cursor[S], CNAME] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, CNAME]
  given showDNSRecordCNAME: Show[CNAME] =
    given Show[Hostname] = Show[Host].contramap[Hostname](identity)
    show.derived[CNAME]
  given codecDNSRecordDNSKEY[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                      NumberType[S], BooleanType[S], StringType[S], Show[S]): Codec[F, S, Cursor[S], DNSKEY] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, DNSKEY]
  given showDNSRecordDNSKEY: Show[DNSKEY] = show.derived[DNSKEY]
  given codecDNSRecordDS[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                  NumberType[S], BooleanType[S], StringType[S], Show[S]): Codec[F, S, Cursor[S], DS] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, DS]
  given showDNSRecordDS: Show[DS] = show.derived[DS]
  given codecDNSRecordHTTPS[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                     NumberType[S], BooleanType[S], StringType[S], Show[S]): Codec[F, S, Cursor[S], HTTPS] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, HTTPS]
  given showDNSRecordHTTPS: Show[HTTPS] = show.derived[HTTPS]
  given codecDNSRecordLOC[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                   NumberType[S], BooleanType[S], StringType[S], Show[S]): Codec[F, S, Cursor[S], LOC] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, LOC]
  given showDNSRecordLOC: Show[LOC] = show.derived[LOC]
  given codecDNSRecordMX[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                  NumberType[S], BooleanType[S], StringType[S], Show[S]): Codec[F, S, Cursor[S], MX] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, MX]
  given showDNSRecordMX: Show[MX] =
    given Show[Hostname] = Show[Host].contramap[Hostname](identity)
    show.derived[MX]
  given codecDNSRecordNAPTR[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                     NumberType[S], BooleanType[S], StringType[S], Show[S]): Codec[F, S, Cursor[S], NAPTR] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, NAPTR]
  given showDNSRecordNAPTR: Show[NAPTR] = show.derived[NAPTR]
  given codecDNSRecordNS[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                  NumberType[S], BooleanType[S], StringType[S], Show[S]): Codec[F, S, Cursor[S], NS] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, NS]
  given showDNSRecordNS: Show[NS] =
    given Show[Hostname] = Show[Host].contramap[Hostname](identity)
    show.derived[NS]
  given codecDNSRecordOPENPGPKEY[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                          NumberType[S], BooleanType[S], StringType[S], Show[S])
  : Codec[F, S, Cursor[S], OPENPGPKEY] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, OPENPGPKEY]
  given showDNSRecordOPENPGPKEY: Show[OPENPGPKEY] = show.derived[OPENPGPKEY]
  given codecDNSRecordPTR[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                   NumberType[S], BooleanType[S], StringType[S], Show[S]): Codec[F, S, Cursor[S], PTR] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, PTR]
  given showDPTRRecordPTR: Show[PTR] = show.derived[PTR]
  given codecDNSRecordSMIMEA[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                      NumberType[S], BooleanType[S], StringType[S], Show[S]): Codec[F, S, Cursor[S], SMIMEA] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, SMIMEA]
  given showDSMIMEARecordSMIMEA: Show[SMIMEA] = show.derived[SMIMEA]
  given codecDNSRecordSRV[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                   NumberType[S], BooleanType[S], StringType[S], Show[S]): Codec[F, S, Cursor[S], SRV] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, SRV]
  given showDSRVRecordSRV: Show[SRV] = show.derived[SRV]
  given codecDNSRecordSSHFP[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                     NumberType[S], BooleanType[S], StringType[S], Show[S]): Codec[F, S, Cursor[S], SSHFP] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, SSHFP]
  given showDSSHFPRecordSSHFP: Show[SSHFP] = show.derived[SSHFP]
  given codecDNSRecordSVCB[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                    NumberType[S], BooleanType[S], StringType[S], Show[S]): Codec[F, S, Cursor[S], SVCB] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, SVCB]
  given showDSVCBRecordSVCB: Show[SVCB] = show.derived[SVCB]
  given codecDNSRecordTLSA[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                    NumberType[S], BooleanType[S], StringType[S], Show[S]): Codec[F, S, Cursor[S], TLSA] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, TLSA]
  given showDTLSARecordTLSA: Show[TLSA] = show.derived[TLSA]
  given codecDNSRecordTXT[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                   NumberType[S], BooleanType[S], StringType[S], Show[S]): Codec[F, S, Cursor[S], TXT] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, TXT]
  given showDTXTRecordTXT: Show[TXT] = show.derived[TXT]
  given codecDNSRecordURI[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                   NumberType[S], BooleanType[S], StringType[S], Show[S]): Codec[F, S, Cursor[S], URI] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, URI]
  given showDNSRecordURI: Show[URI] = show.derived[URI]
  given codecDNSRecord[F[_], S](using config: CodecConfig, monad: Monad[F], objectType: ObjectType[S],
                                nullType: NullType[S], arrayType: ArrayType[S], numberType: NumberType[S],
                                booleanType: BooleanType[S], stringType: StringType[S], show: Show[S])
  : Codec[F, S, Cursor[S], DNSRecord] =
    Codec.derived[F, S, DNSRecord](using config.withDiscriminator("type"))

  given showDNSRecord: Show[DNSRecord] = show.derived[DNSRecord]
end DNSRecordInstances
object DNSRecordInstances extends DNSRecordInstances
