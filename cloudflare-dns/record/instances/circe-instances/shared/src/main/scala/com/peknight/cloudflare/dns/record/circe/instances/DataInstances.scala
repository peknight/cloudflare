package com.peknight.cloudflare.dns.record.circe.instances

import cats.Monad
import com.peknight.cloudflare.dns.record.*
import com.peknight.cloudflare.dns.record.codec.instances.{LatitudeDirectionInstances, LongitudeDirectionInstances}
import com.peknight.codec.Codec
import com.peknight.codec.circe.sum.JsonTypeInstances
import com.peknight.codec.configuration.CodecConfiguration
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.ip4s.instances.{HostInstances, PortInstances}
import io.circe.Json

trait DataInstances extends LatitudeDirectionInstances
  with LongitudeDirectionInstances
  with HostInstances
  with PortInstances
  with JsonTypeInstances:
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
