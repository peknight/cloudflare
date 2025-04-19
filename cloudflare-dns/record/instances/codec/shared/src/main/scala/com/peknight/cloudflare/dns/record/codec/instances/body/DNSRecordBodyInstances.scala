package com.peknight.cloudflare.dns.record.codec.instances.body

import cats.syntax.contravariant.*
import cats.{Monad, Show}
import com.comcast.ip4s.{Host, Hostname, Ipv4Address, Ipv6Address}
import com.peknight.cloudflare.dns.record.body.DNSRecordBody
import com.peknight.cloudflare.dns.record.body.DNSRecordBody.*
import com.peknight.cloudflare.dns.record.codec.instances.dnsRecordData.given
import com.peknight.cloudflare.dns.record.codec.instances.dnsRecordSettings.given
import com.peknight.cloudflare.dns.record.codec.instances.dnsRecordType.given
import com.peknight.codec.Codec
import com.peknight.codec.config.CodecConfig
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.instances.time.finiteDuration.codecFiniteDurationOfSecondsNS
import com.peknight.codec.ip4s.instances.host.given
import com.peknight.codec.sum.*
import com.peknight.generic.derivation.show

import scala.concurrent.duration.FiniteDuration

trait DNSRecordBodyInstances:
  given codecDNSRecordBodyA[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                     NumberType[S], BooleanType[S], StringType[S], Show[S]): Codec[F, S, Cursor[S], A] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, A]
  given showDNSRecordBodyA: Show[A] =
    given Show[Ipv4Address] = Show[Host].contramap[Ipv4Address](identity)
    show.derived[A]
  given codecDNSRecordBodyAAAA[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                        NumberType[S], BooleanType[S], StringType[S], Show[S]): Codec[F, S, Cursor[S], AAAA] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, AAAA]
  given showDNSRecordBodyAAAA: Show[AAAA] =
    given Show[Ipv6Address] = Show[Host].contramap[Ipv6Address](identity)
    show.derived[AAAA]
  given codecDNSRecordBodyCAA[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                       NumberType[S], StringType[S], Show[S]): Codec[F, S, Cursor[S], CAA] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, CAA]
  given showDNSRecordBodyCAA: Show[CAA] = show.derived[CAA]
  given codecDNSRecordBodyCERT[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                        NumberType[S], StringType[S], Show[S]): Codec[F, S, Cursor[S], CERT] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, CERT]
  given showDNSRecordBodyCERT: Show[CERT] = show.derived[CERT]
  given codecDNSRecordBodyCNAME[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                         NumberType[S], BooleanType[S], StringType[S], Show[S]): Codec[F, S, Cursor[S], CNAME] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, CNAME]
  given showDNSRecordBodyCNAME: Show[CNAME] =
    given Show[Hostname] = Show[Host].contramap[Hostname](identity)
    show.derived[CNAME]
  given codecDNSRecordBodyDNSKEY[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                          NumberType[S], StringType[S], Show[S]): Codec[F, S, Cursor[S], DNSKEY] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, DNSKEY]
  given showDNSRecordBodyDNSKEY: Show[DNSKEY] = show.derived[DNSKEY]
  given codecDNSRecordBodyDS[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                      NumberType[S], StringType[S], Show[S]): Codec[F, S, Cursor[S], DS] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, DS]
  given showDNSRecordBodyDS: Show[DS] = show.derived[DS]
  given codecDNSRecordBodyHTTPS[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                         NumberType[S], StringType[S], Show[S]): Codec[F, S, Cursor[S], HTTPS] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, HTTPS]
  given showDNSRecordBodyHTTPS: Show[HTTPS] = show.derived[HTTPS]
  given codecDNSRecordBodyLOC[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                       NumberType[S], StringType[S], Show[S]): Codec[F, S, Cursor[S], LOC] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, LOC]
  given showDNSRecordBodyLOC: Show[LOC] = show.derived[LOC]
  given codecDNSRecordBodyMX[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                      NumberType[S], StringType[S], Show[S]): Codec[F, S, Cursor[S], MX] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, MX]
  given showDNSRecordBodyMX: Show[MX] =
    given Show[Hostname] = Show[Host].contramap[Hostname](identity)
    show.derived[MX]
  given codecDNSRecordBodyNAPTR[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                         NumberType[S], StringType[S], Show[S]): Codec[F, S, Cursor[S], NAPTR] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, NAPTR]
  given showDNSRecordBodyNAPTR: Show[NAPTR] = show.derived[NAPTR]
  given codecDNSRecordBodyNS[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                      NumberType[S], StringType[S], Show[S]): Codec[F, S, Cursor[S], NS] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, NS]
  given showDNSRecordBodyNS: Show[NS] =
    given Show[Hostname] = Show[Host].contramap[Hostname](identity)
    show.derived[NS]
  given codecDNSRecordBodyOPENPGPKEY[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                              NumberType[S], StringType[S], Show[S]): Codec[F, S, Cursor[S], OPENPGPKEY] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, OPENPGPKEY]
  given showDNSRecordBodyOPENPGPKEY: Show[OPENPGPKEY] = show.derived[OPENPGPKEY]
  given codecDNSRecordBodyPTR[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                       NumberType[S], StringType[S], Show[S]): Codec[F, S, Cursor[S], PTR] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, PTR]
  given showDPTRRecordBodyPTR: Show[PTR] = show.derived[PTR]
  given codecDNSRecordBodySMIMEA[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                          NumberType[S], StringType[S], Show[S]): Codec[F, S, Cursor[S], SMIMEA] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, SMIMEA]
  given showDSMIMEARecordBodySMIMEA: Show[SMIMEA] = show.derived[SMIMEA]
  given codecDNSRecordBodySRV[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                       NumberType[S], StringType[S], Show[S]): Codec[F, S, Cursor[S], SRV] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, SRV]
  given showDSRVRecordBodySRV: Show[SRV] = show.derived[SRV]
  given codecDNSRecordBodySSHFP[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                         NumberType[S], StringType[S], Show[S]): Codec[F, S, Cursor[S], SSHFP] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, SSHFP]
  given showDSSHFPRecordBodySSHFP: Show[SSHFP] = show.derived[SSHFP]
  given codecDNSRecordBodySVCB[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                        NumberType[S], StringType[S], Show[S]): Codec[F, S, Cursor[S], SVCB] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, SVCB]
  given showDSVCBRecordBodySVCB: Show[SVCB] = show.derived[SVCB]
  given codecDNSRecordBodyTLSA[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                        NumberType[S], StringType[S], Show[S]): Codec[F, S, Cursor[S], TLSA] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, TLSA]
  given showDTLSARecordBodyTLSA: Show[TLSA] = show.derived[TLSA]
  given codecDNSRecordBodyTXT[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                       NumberType[S], StringType[S], Show[S]): Codec[F, S, Cursor[S], TXT] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, TXT]
  given showDTXTRecordBodyTXT: Show[TXT] = show.derived[TXT]
  given codecDNSRecordBodyURI[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                       NumberType[S], StringType[S], Show[S]): Codec[F, S, Cursor[S], URI] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, URI]
  given showDNSRecordBodyURI: Show[URI] = show.derived[URI]
  given codecDNSRecordBody[F[_], S](using config: CodecConfig, monad: Monad[F], objectType: ObjectType[S],
                                    nullType: NullType[S], arrayType: ArrayType[S], numberType: NumberType[S],
                                    booleanType: BooleanType[S], stringType: StringType[S], show: Show[S])
  : Codec[F, S, Cursor[S], DNSRecordBody] =
    Codec.derived[F, S, DNSRecordBody](using config.withDiscriminator("type"))
  given showDNSRecordBody: Show[DNSRecordBody] = show.derived[DNSRecordBody]
end DNSRecordBodyInstances
object DNSRecordBodyInstances extends DNSRecordBodyInstances
