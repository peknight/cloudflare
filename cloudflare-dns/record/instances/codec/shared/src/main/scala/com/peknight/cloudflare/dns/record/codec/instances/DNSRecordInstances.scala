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
import com.peknight.codec.configuration.CodecConfiguration
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.ip4s.instances.host.given
import com.peknight.codec.ip4s.instances.port.given
import com.peknight.codec.sum.*

//noinspection DuplicatedCode
trait DNSRecordInstances:
  given codecDNSRecordA[F[_], S](using CodecConfiguration, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                 NumberType[S], BooleanType[S], StringType[S]): Codec[F, S, Cursor[S], A] =
    Codec.derived[F, S, A]
  given codecDNSRecordAAAA[F[_], S](using CodecConfiguration, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                    NumberType[S], BooleanType[S], StringType[S]): Codec[F, S, Cursor[S], AAAA] =
    Codec.derived[F, S, AAAA]
  given codecDNSRecordCAA[F[_], S](using CodecConfiguration, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                   NumberType[S], BooleanType[S], StringType[S]): Codec[F, S, Cursor[S], CAA] =
    Codec.derived[F, S, CAA]
  given codecDNSRecordCERT[F[_], S](using CodecConfiguration, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                    NumberType[S], BooleanType[S], StringType[S]): Codec[F, S, Cursor[S], CERT] =
    Codec.derived[F, S, CERT]
  given codecDNSRecordCNAME[F[_], S](using CodecConfiguration, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                     NumberType[S], BooleanType[S], StringType[S]): Codec[F, S, Cursor[S], CNAME] =
    Codec.derived[F, S, CNAME]
  given codecDNSRecordDNSKEY[F[_], S](using CodecConfiguration, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                      NumberType[S], BooleanType[S], StringType[S]): Codec[F, S, Cursor[S], DNSKEY] =
    Codec.derived[F, S, DNSKEY]
  given codecDNSRecordDS[F[_], S](using CodecConfiguration, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                  NumberType[S], BooleanType[S], StringType[S]): Codec[F, S, Cursor[S], DS] =
    Codec.derived[F, S, DS]
  given codecDNSRecordHTTPS[F[_], S](using CodecConfiguration, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                     NumberType[S], BooleanType[S], StringType[S]): Codec[F, S, Cursor[S], HTTPS] =
    Codec.derived[F, S, HTTPS]
  given codecDNSRecordLOC[F[_], S](using CodecConfiguration, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                   NumberType[S], BooleanType[S], StringType[S]): Codec[F, S, Cursor[S], LOC] =
    Codec.derived[F, S, LOC]
  given codecDNSRecordMX[F[_], S](using CodecConfiguration, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                  NumberType[S], BooleanType[S], StringType[S]): Codec[F, S, Cursor[S], MX] =
    Codec.derived[F, S, MX]
  given codecDNSRecordNAPTR[F[_], S](using CodecConfiguration, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                     NumberType[S], BooleanType[S], StringType[S]): Codec[F, S, Cursor[S], NAPTR] =
    Codec.derived[F, S, NAPTR]
  given codecDNSRecordNS[F[_], S](using CodecConfiguration, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                  NumberType[S], BooleanType[S], StringType[S]): Codec[F, S, Cursor[S], NS] =
    Codec.derived[F, S, NS]
  given codecDNSRecordOPENPGPKEY[F[_], S](using CodecConfiguration, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                          NumberType[S], BooleanType[S], StringType[S])
  : Codec[F, S, Cursor[S], OPENPGPKEY] =
    Codec.derived[F, S, OPENPGPKEY]
  given codecDNSRecordPTR[F[_], S](using CodecConfiguration, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                   NumberType[S], BooleanType[S], StringType[S]): Codec[F, S, Cursor[S], PTR] =
    Codec.derived[F, S, PTR]
  given codecDNSRecordSMIMEA[F[_], S](using CodecConfiguration, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                      NumberType[S], BooleanType[S], StringType[S]): Codec[F, S, Cursor[S], SMIMEA] =
    Codec.derived[F, S, SMIMEA]
  given codecDNSRecordSRV[F[_], S](using CodecConfiguration, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                   NumberType[S], BooleanType[S], StringType[S]): Codec[F, S, Cursor[S], SRV] =
    Codec.derived[F, S, SRV]
  given codecDNSRecordSSHFP[F[_], S](using CodecConfiguration, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                     NumberType[S], BooleanType[S], StringType[S]): Codec[F, S, Cursor[S], SSHFP] =
    Codec.derived[F, S, SSHFP]
  given codecDNSRecordSVCB[F[_], S](using CodecConfiguration, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                    NumberType[S], BooleanType[S], StringType[S]): Codec[F, S, Cursor[S], SVCB] =
    Codec.derived[F, S, SVCB]
  given codecDNSRecordTLSA[F[_], S](using CodecConfiguration, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                    NumberType[S], BooleanType[S], StringType[S]): Codec[F, S, Cursor[S], TLSA] =
    Codec.derived[F, S, TLSA]
  given codecDNSRecordTXT[F[_], S](using CodecConfiguration, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                   NumberType[S], BooleanType[S], StringType[S]): Codec[F, S, Cursor[S], TXT] =
    Codec.derived[F, S, TXT]
  given codecDNSRecordURI[F[_], S](using CodecConfiguration, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                   NumberType[S], BooleanType[S], StringType[S]): Codec[F, S, Cursor[S], URI] =
    Codec.derived[F, S, URI]
  given codecDNSRecord[F[_], S](using configuration: CodecConfiguration, monad: Monad[F], objectType: ObjectType[S],
                                nullType: NullType[S], arrayType: ArrayType[S], numberType: NumberType[S],
                                booleanType: BooleanType[S], stringType: StringType[S])
  : Codec[F, S, Cursor[S], DNSRecord] =
    Codec.derived[F, S, DNSRecord](using configuration.withDiscriminator("type"))
end DNSRecordInstances
object DNSRecordInstances extends DNSRecordInstances
