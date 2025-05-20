package com.peknight.cloudflare.dns.record.codec.instances

import cats.{Monad, Show}
import com.peknight.cloudflare.dns.record.*
import com.peknight.cloudflare.dns.record.codec.instances.latitudeDirection.given
import com.peknight.cloudflare.dns.record.codec.instances.longitudeDirection.given
import com.peknight.codec.Codec
import com.peknight.codec.config.CodecConfig
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.ip4s.instances.host.given
import com.peknight.codec.ip4s.instances.port.given
import com.peknight.codec.sum.*

trait DNSRecordDataInstances:
  given codecDNSRecordCAAData[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], NumberType[S],
                                       StringType[S], Show[S]): Codec[F, S, Cursor[S], CAAData] =
    Codec.derived[F, S, CAAData]

  given codecDNSRecordCERTData[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], NumberType[S],
                                        StringType[S], Show[S]): Codec[F, S, Cursor[S], CERTData] =
    Codec.derived[F, S, CERTData]

  given codecDNSRecordDNSKEYData[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], NumberType[S],
                                          StringType[S], Show[S]): Codec[F, S, Cursor[S], DNSKEYData] =
    Codec.derived[F, S, DNSKEYData]

  given codecDNSRecordDSData[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], NumberType[S],
                                      StringType[S], Show[S]): Codec[F, S, Cursor[S], DSData] =
    Codec.derived[F, S, DSData]

  given codecDNSRecordHTTPSData[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], NumberType[S],
                                         StringType[S], Show[S]): Codec[F, S, Cursor[S], HTTPSData] =
    Codec.derived[F, S, HTTPSData]

  given codecDNSRecordLOCData[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], NumberType[S],
                                       StringType[S], Show[S]): Codec[F, S, Cursor[S], LOCData] =
    Codec.derived[F, S, LOCData]

  given codecDNSRecordNAPTRData[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], NumberType[S],
                                         StringType[S], Show[S]): Codec[F, S, Cursor[S], NAPTRData] =
    Codec.derived[F, S, NAPTRData]

  given codecDNSRecordSMIMEAData[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], NumberType[S],
                                          StringType[S], Show[S]): Codec[F, S, Cursor[S], SMIMEAData] =
    Codec.derived[F, S, SMIMEAData]

  given codecDNSRecordSRVData[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], NumberType[S],
                                       StringType[S], Show[S]): Codec[F, S, Cursor[S], SRVData] =
    Codec.derived[F, S, SRVData]

  given codecDNSRecordSSHFPData[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], NumberType[S],
                                         StringType[S], Show[S]): Codec[F, S, Cursor[S], SSHFPData] =
    Codec.derived[F, S, SSHFPData]

  given codecDNSRecordSVCBData[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], NumberType[S],
                                        StringType[S], Show[S]): Codec[F, S, Cursor[S], SVCBData] =
    Codec.derived[F, S, SVCBData]

  given codecDNSRecordTLSAData[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], NumberType[S],
                                        StringType[S], Show[S]): Codec[F, S, Cursor[S], TLSAData] =
    Codec.derived[F, S, TLSAData]

  given codecDNSRecordURIData[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], NumberType[S],
                                       StringType[S], Show[S]): Codec[F, S, Cursor[S], URIData] =
    Codec.derived[F, S, URIData]
end DNSRecordDataInstances
object DNSRecordDataInstances extends DNSRecordDataInstances
