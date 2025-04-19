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
import com.peknight.generic.derivation.show

trait DNSRecordDataInstances:
  given codecDNSRecordCAAData[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], NumberType[S],
                                       StringType[S], Show[S]): Codec[F, S, Cursor[S], CAAData] =
    Codec.derived[F, S, CAAData]
  given showDNSRecordCAAData: Show[CAAData] = Show.fromToString[CAAData]

  given codecDNSRecordCERTData[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], NumberType[S],
                                        StringType[S], Show[S]): Codec[F, S, Cursor[S], CERTData] =
    Codec.derived[F, S, CERTData]
  given showDNSRecordCERTData: Show[CERTData] = Show.fromToString[CERTData]

  given codecDNSRecordDNSKEYData[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], NumberType[S],
                                          StringType[S], Show[S]): Codec[F, S, Cursor[S], DNSKEYData] =
    Codec.derived[F, S, DNSKEYData]
  given showDNSRecordDNSKEYData: Show[DNSKEYData] = Show.fromToString[DNSKEYData]

  given codecDNSRecordDSData[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], NumberType[S],
                                      StringType[S], Show[S]): Codec[F, S, Cursor[S], DSData] =
    Codec.derived[F, S, DSData]
  given showDNSRecordDSData: Show[DSData] = Show.fromToString[DSData]

  given codecDNSRecordHTTPSData[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], NumberType[S],
                                         StringType[S], Show[S]): Codec[F, S, Cursor[S], HTTPSData] =
    Codec.derived[F, S, HTTPSData]
  given showDNSRecordHTTPSData: Show[HTTPSData] = Show.fromToString[HTTPSData]

  given codecDNSRecordLOCData[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], NumberType[S],
                                       StringType[S], Show[S]): Codec[F, S, Cursor[S], LOCData] =
    Codec.derived[F, S, LOCData]
  given showDNSRecordLOCData: Show[LOCData] = Show.fromToString[LOCData]

  given codecDNSRecordNAPTRData[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], NumberType[S],
                                         StringType[S], Show[S]): Codec[F, S, Cursor[S], NAPTRData] =
    Codec.derived[F, S, NAPTRData]
  given showDNSRecordNAPTRData: Show[NAPTRData] = Show.fromToString[NAPTRData]

  given codecDNSRecordSMIMEAData[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], NumberType[S],
                                          StringType[S], Show[S]): Codec[F, S, Cursor[S], SMIMEAData] =
    Codec.derived[F, S, SMIMEAData]
  given showDNSRecordSMIMEAData: Show[SMIMEAData] = Show.fromToString[SMIMEAData]

  given codecDNSRecordSRVData[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], NumberType[S],
                                       StringType[S], Show[S]): Codec[F, S, Cursor[S], SRVData] =
    Codec.derived[F, S, SRVData]
  given showDNSRecordSRVData: Show[SRVData] = Show.fromToString[SRVData]

  given codecDNSRecordSSHFPData[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], NumberType[S],
                                         StringType[S], Show[S]): Codec[F, S, Cursor[S], SSHFPData] =
    Codec.derived[F, S, SSHFPData]
  given showDNSRecordSSHFPData: Show[SSHFPData] = Show.fromToString[SSHFPData]

  given codecDNSRecordSVCBData[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], NumberType[S],
                                        StringType[S], Show[S]): Codec[F, S, Cursor[S], SVCBData] =
    Codec.derived[F, S, SVCBData]
  given showDNSRecordSVCBData: Show[SVCBData] = Show.fromToString[SVCBData]

  given codecDNSRecordTLSAData[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], NumberType[S],
                                        StringType[S], Show[S]): Codec[F, S, Cursor[S], TLSAData] =
    Codec.derived[F, S, TLSAData]
  given showDNSRecordTLSAData: Show[TLSAData] = Show.fromToString[TLSAData]

  given codecDNSRecordURIData[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], NumberType[S],
                                       StringType[S], Show[S]): Codec[F, S, Cursor[S], URIData] =
    Codec.derived[F, S, URIData]
  given showDNSRecordURIData: Show[URIData] = Show.fromToString[URIData]
end DNSRecordDataInstances
object DNSRecordDataInstances extends DNSRecordDataInstances
