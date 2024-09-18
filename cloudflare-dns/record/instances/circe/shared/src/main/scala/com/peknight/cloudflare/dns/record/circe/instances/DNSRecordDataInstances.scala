package com.peknight.cloudflare.dns.record.circe.instances

import cats.Monad
import com.peknight.cloudflare.dns.record.*
import com.peknight.cloudflare.dns.record.codec.instances.dnsRecordData.given
import com.peknight.codec.Codec
import com.peknight.codec.circe.sum.jsonType.given
import com.peknight.codec.configuration.CodecConfiguration
import com.peknight.codec.cursor.Cursor
import io.circe.Json

trait DNSRecordDataInstances:
  given jsonCodecDNSRecordCAAData[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], CAAData] =
    codecDNSRecordCAAData[F, Json]
  given jsonCodecDNSRecordCERTData[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], CERTData] =
    codecDNSRecordCERTData[F, Json]
  given jsonCodecDNSRecordDNSKEYData[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], DNSKEYData] =
    codecDNSRecordDNSKEYData[F, Json]
  given jsonCodecDNSRecordDSData[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], DSData] =
    codecDNSRecordDSData[F, Json]
  given jsonCodecDNSRecordHTTPSData[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], HTTPSData] =
    codecDNSRecordHTTPSData[F, Json]
  given jsonCodecDNSRecordLOCData[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], LOCData] =
    codecDNSRecordLOCData[F, Json]
  given jsonCodecDNSRecordNAPTRData[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], NAPTRData] =
    codecDNSRecordNAPTRData[F, Json]
  given jsonCodecDNSRecordSMIMEAData[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], SMIMEAData] =
    codecDNSRecordSMIMEAData[F, Json]
  given jsonCodecDNSRecordSRVData[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], SRVData] =
    codecDNSRecordSRVData[F, Json]
  given jsonCodecDNSRecordSSHFPData[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], SSHFPData] =
    codecDNSRecordSSHFPData[F, Json]
  given jsonCodecDNSRecordSVCBData[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], SVCBData] =
    codecDNSRecordSVCBData[F, Json]
  given jsonCodecDNSRecordTLSAData[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], TLSAData] =
    codecDNSRecordTLSAData[F, Json]
  given jsonCodecDNSRecordURIData[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], URIData] =
    codecDNSRecordURIData[F, Json]
end DNSRecordDataInstances
object DNSRecordDataInstances extends DNSRecordDataInstances
