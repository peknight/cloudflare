package com.peknight.cloudflare.dns.record.codec.instances

import cats.Monad
import com.peknight.cloudflare.dns.record.DNSRecord
import com.peknight.cloudflare.dns.record.DNSRecord.*
import com.peknight.cloudflare.dns.record.codec.instances.dnsRecordData.given
import com.peknight.cloudflare.dns.record.codec.instances.dnsRecordId.given
import com.peknight.cloudflare.dns.record.codec.instances.dnsRecordMeta.given
import com.peknight.cloudflare.dns.record.codec.instances.dnsRecordSettings.given
import com.peknight.cloudflare.dns.record.codec.instances.dnsRecordType.given
import com.peknight.cloudflare.zone.codec.instances.zoneId.given
import com.peknight.codec.Codec
import com.peknight.codec.config.CodecConfig
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.instances.time.finiteDuration.codecFiniteDurationOfSecondsNS
import com.peknight.codec.ip4s.instances.host.given
import com.peknight.codec.ip4s.instances.port.given
import com.peknight.codec.sum.*

import scala.concurrent.duration.FiniteDuration

//noinspection DuplicatedCode
trait DNSRecordInstances:
  given codecDNSRecordA[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                 NumberType[S], BooleanType[S], StringType[S]): Codec[F, S, Cursor[S], A] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, A]
  given codecDNSRecordAAAA[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                    NumberType[S], BooleanType[S], StringType[S]): Codec[F, S, Cursor[S], AAAA] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, AAAA]
  given codecDNSRecordCAA[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                   NumberType[S], BooleanType[S], StringType[S]): Codec[F, S, Cursor[S], CAA] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, CAA]
  given codecDNSRecordCERT[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                    NumberType[S], BooleanType[S], StringType[S]): Codec[F, S, Cursor[S], CERT] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, CERT]
  given codecDNSRecordCNAME[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                     NumberType[S], BooleanType[S], StringType[S]): Codec[F, S, Cursor[S], CNAME] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, CNAME]
  given codecDNSRecordDNSKEY[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                      NumberType[S], BooleanType[S], StringType[S]): Codec[F, S, Cursor[S], DNSKEY] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, DNSKEY]
  given codecDNSRecordDS[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                  NumberType[S], BooleanType[S], StringType[S]): Codec[F, S, Cursor[S], DS] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, DS]
  given codecDNSRecordHTTPS[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                     NumberType[S], BooleanType[S], StringType[S]): Codec[F, S, Cursor[S], HTTPS] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, HTTPS]
  given codecDNSRecordLOC[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                   NumberType[S], BooleanType[S], StringType[S]): Codec[F, S, Cursor[S], LOC] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, LOC]
  given codecDNSRecordMX[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                  NumberType[S], BooleanType[S], StringType[S]): Codec[F, S, Cursor[S], MX] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, MX]
  given codecDNSRecordNAPTR[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                     NumberType[S], BooleanType[S], StringType[S]): Codec[F, S, Cursor[S], NAPTR] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, NAPTR]
  given codecDNSRecordNS[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                  NumberType[S], BooleanType[S], StringType[S]): Codec[F, S, Cursor[S], NS] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, NS]
  given codecDNSRecordOPENPGPKEY[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                          NumberType[S], BooleanType[S], StringType[S])
  : Codec[F, S, Cursor[S], OPENPGPKEY] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, OPENPGPKEY]
  given codecDNSRecordPTR[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                   NumberType[S], BooleanType[S], StringType[S]): Codec[F, S, Cursor[S], PTR] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, PTR]
  given codecDNSRecordSMIMEA[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                      NumberType[S], BooleanType[S], StringType[S]): Codec[F, S, Cursor[S], SMIMEA] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, SMIMEA]
  given codecDNSRecordSRV[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                   NumberType[S], BooleanType[S], StringType[S]): Codec[F, S, Cursor[S], SRV] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, SRV]
  given codecDNSRecordSSHFP[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                     NumberType[S], BooleanType[S], StringType[S]): Codec[F, S, Cursor[S], SSHFP] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, SSHFP]
  given codecDNSRecordSVCB[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                    NumberType[S], BooleanType[S], StringType[S]): Codec[F, S, Cursor[S], SVCB] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, SVCB]
  given codecDNSRecordTLSA[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                    NumberType[S], BooleanType[S], StringType[S]): Codec[F, S, Cursor[S], TLSA] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, TLSA]
  given codecDNSRecordTXT[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                   NumberType[S], BooleanType[S], StringType[S]): Codec[F, S, Cursor[S], TXT] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, TXT]
  given codecDNSRecordURI[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                   NumberType[S], BooleanType[S], StringType[S]): Codec[F, S, Cursor[S], URI] =
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, URI]
  given codecDNSRecord[F[_], S](using config: CodecConfig, monad: Monad[F], objectType: ObjectType[S],
                                nullType: NullType[S], arrayType: ArrayType[S], numberType: NumberType[S],
                                booleanType: BooleanType[S], stringType: StringType[S])
  : Codec[F, S, Cursor[S], DNSRecord] =
    Codec.derived[F, S, DNSRecord](using config.withDiscriminator("type"))
end DNSRecordInstances
object DNSRecordInstances extends DNSRecordInstances
