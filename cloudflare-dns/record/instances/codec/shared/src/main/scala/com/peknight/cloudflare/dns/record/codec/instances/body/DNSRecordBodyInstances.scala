package com.peknight.cloudflare.dns.record.codec.instances.body

import cats.Monad
import com.peknight.cloudflare.dns.record.body.DNSRecordBody
import com.peknight.cloudflare.dns.record.body.DNSRecordBody.*
import com.peknight.cloudflare.dns.record.codec.instances.dnsRecordData.given
import com.peknight.cloudflare.dns.record.codec.instances.dnsRecordSettings.given
import com.peknight.cloudflare.dns.record.codec.instances.dnsRecordType.given
import com.peknight.codec.Codec
import com.peknight.codec.configuration.CodecConfiguration
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.ip4s.instances.host.given
import com.peknight.codec.sum.*

trait DNSRecordBodyInstances:
  given codecDNSRecordBodyA[F[_], S](using CodecConfiguration, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                     NumberType[S], BooleanType[S], StringType[S]): Codec[F, S, Cursor[S], A] =
    Codec.derived[F, S, A]
  given codecDNSRecordBodyAAAA[F[_], S](using CodecConfiguration, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                        NumberType[S], BooleanType[S], StringType[S]): Codec[F, S, Cursor[S], AAAA] =
    Codec.derived[F, S, AAAA]
  given codecDNSRecordBodyCAA[F[_], S](using CodecConfiguration, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                       NumberType[S], StringType[S]): Codec[F, S, Cursor[S], CAA] =
    Codec.derived[F, S, CAA]
  given codecDNSRecordBodyCERT[F[_], S](using CodecConfiguration, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                        NumberType[S], StringType[S]): Codec[F, S, Cursor[S], CERT] =
    Codec.derived[F, S, CERT]
  given codecDNSRecordBodyCNAME[F[_], S](using CodecConfiguration, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                         NumberType[S], BooleanType[S], StringType[S]): Codec[F, S, Cursor[S], CNAME] =
    Codec.derived[F, S, CNAME]
  given codecDNSRecordBodyDNSKEY[F[_], S](using CodecConfiguration, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                          NumberType[S], StringType[S]): Codec[F, S, Cursor[S], DNSKEY] =
    Codec.derived[F, S, DNSKEY]
  given codecDNSRecordBodyDS[F[_], S](using CodecConfiguration, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                      NumberType[S], StringType[S]): Codec[F, S, Cursor[S], DS] =
    Codec.derived[F, S, DS]
  given codecDNSRecordBodyHTTPS[F[_], S](using CodecConfiguration, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                         NumberType[S], StringType[S]): Codec[F, S, Cursor[S], HTTPS] =
    Codec.derived[F, S, HTTPS]
  given codecDNSRecordBodyLOC[F[_], S](using CodecConfiguration, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                       NumberType[S], StringType[S]): Codec[F, S, Cursor[S], LOC] =
    Codec.derived[F, S, LOC]
  given codecDNSRecordBodyMX[F[_], S](using CodecConfiguration, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                      NumberType[S], StringType[S]): Codec[F, S, Cursor[S], MX] =
    Codec.derived[F, S, MX]
  given codecDNSRecordBodyNAPTR[F[_], S](using CodecConfiguration, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                         NumberType[S], StringType[S]): Codec[F, S, Cursor[S], NAPTR] =
    Codec.derived[F, S, NAPTR]
  given codecDNSRecordBodyNS[F[_], S](using CodecConfiguration, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                      NumberType[S], StringType[S]): Codec[F, S, Cursor[S], NS] =
    Codec.derived[F, S, NS]
  given codecDNSRecordBodyOPENPGPKEY[F[_], S](using CodecConfiguration, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                              NumberType[S], StringType[S]): Codec[F, S, Cursor[S], OPENPGPKEY] =
    Codec.derived[F, S, OPENPGPKEY]
  given codecDNSRecordBodyPTR[F[_], S](using CodecConfiguration, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                       NumberType[S], StringType[S]): Codec[F, S, Cursor[S], PTR] =
    Codec.derived[F, S, PTR]
  given codecDNSRecordBodySMIMEA[F[_], S](using CodecConfiguration, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                          NumberType[S], StringType[S]): Codec[F, S, Cursor[S], SMIMEA] =
    Codec.derived[F, S, SMIMEA]
  given codecDNSRecordBodySRV[F[_], S](using CodecConfiguration, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                       NumberType[S], StringType[S]): Codec[F, S, Cursor[S], SRV] =
    Codec.derived[F, S, SRV]
  given codecDNSRecordBodySSHFP[F[_], S](using CodecConfiguration, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                         NumberType[S], StringType[S]): Codec[F, S, Cursor[S], SSHFP] =
    Codec.derived[F, S, SSHFP]
  given codecDNSRecordBodySVCB[F[_], S](using CodecConfiguration, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                        NumberType[S], StringType[S]): Codec[F, S, Cursor[S], SVCB] =
    Codec.derived[F, S, SVCB]
  given codecDNSRecordBodyTLSA[F[_], S](using CodecConfiguration, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                        NumberType[S], StringType[S]): Codec[F, S, Cursor[S], TLSA] =
    Codec.derived[F, S, TLSA]
  given codecDNSRecordBodyTXT[F[_], S](using CodecConfiguration, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                       NumberType[S], StringType[S]): Codec[F, S, Cursor[S], TXT] =
    Codec.derived[F, S, TXT]
  given codecDNSRecordBodyURI[F[_], S](using CodecConfiguration, Monad[F], ObjectType[S], NullType[S], ArrayType[S],
                                       NumberType[S], StringType[S]): Codec[F, S, Cursor[S], URI] =
    Codec.derived[F, S, URI]
  given codecDNSRecordBody[F[_], S](using configuration: CodecConfiguration, monad: Monad[F], objectType: ObjectType[S],
                                    nullType: NullType[S], arrayType: ArrayType[S], numberType: NumberType[S],
                                    booleanType: BooleanType[S], stringType: StringType[S])
  : Codec[F, S, Cursor[S], DNSRecordBody] =
    Codec.derived[F, S, DNSRecordBody](using configuration.withDiscriminator("type"))
end DNSRecordBodyInstances
object DNSRecordBodyInstances extends DNSRecordBodyInstances
