package com.peknight.cloudflare.dns.record.circe.instances

import cats.Monad
import com.peknight.cloudflare.dns.record.*
import com.peknight.cloudflare.dns.record.codec.instances.latitudeDirection.given
import com.peknight.cloudflare.dns.record.codec.instances.longitudeDirection.given
import com.peknight.codec.Codec
import com.peknight.codec.circe.sum.jsonType.given
import com.peknight.codec.configuration.CodecConfiguration
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.ip4s.instances.host.given
import com.peknight.codec.ip4s.instances.port.given
import io.circe.Json

trait DataInstances:
  given codecDNSRecordCAAData[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], CAAData] =
    Codec.derived[F, Json, CAAData]
  given codecDNSRecordCERTData[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], CERTData] =
    Codec.derived[F, Json, CERTData]
  given codecDNSRecordDNSKEYData[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], DNSKEYData] =
    Codec.derived[F, Json, DNSKEYData]
  given codecDNSRecordDSData[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], DSData] =
    Codec.derived[F, Json, DSData]
  given codecDNSRecordHTTPSData[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], HTTPSData] =
    Codec.derived[F, Json, HTTPSData]
  given codecDNSRecordLOCData[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], LOCData] =
    Codec.derived[F, Json, LOCData]
  given codecDNSRecordNAPTRData[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], NAPTRData] =
    Codec.derived[F, Json, NAPTRData]
  given codecDNSRecordSMIMEAData[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], SMIMEAData] =
    Codec.derived[F, Json, SMIMEAData]
  given codecDNSRecordSRVData[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], SRVData] =
    Codec.derived[F, Json, SRVData]
  given codecDNSRecordSSHFPData[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], SSHFPData] =
    Codec.derived[F, Json, SSHFPData]
  given codecDNSRecordSVCBData[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], SVCBData] =
    Codec.derived[F, Json, SVCBData]
  given codecDNSRecordTLSAData[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], TLSAData] =
    Codec.derived[F, Json, TLSAData]
  given codecDNSRecordURIData[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], URIData] =
    Codec.derived[F, Json, URIData]
end DataInstances
object DataInstances extends DataInstances
