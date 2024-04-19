package com.peknight.cloudflare.dns.record.circe.instances

import cats.Monad
import com.peknight.cloudflare.dns.record.*
import com.peknight.cloudflare.dns.record.DNSRecord.*
import com.peknight.cloudflare.dns.record.codec.instances.AllInstances
import com.peknight.cloudflare.zone.codec.instances.ZoneIdInstances
import com.peknight.codec.Codec
import com.peknight.codec.circe.sum.JsonTypeInstances
import com.peknight.codec.configuration.CodecConfiguration
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.ip4s.instances.{HostInstances, PortInstances}
import io.circe.Json

trait DNSRecordInstances extends AllInstances
  with HostInstances
  with PortInstances
  with ZoneIdInstances
  with JsonTypeInstances:

  given codecDNSRecordMeta[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], DNSRecordMeta] =
    Codec.derived[F, Json, DNSRecordMeta]

  given codecDNSRecordA[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], A] =
    Codec.derived[F, Json, A]
  given codecDNSRecordAAAA[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], AAAA] =
    Codec.derived[F, Json, AAAA]
  given codecDNSRecordCAAData[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], CAAData] =
    Codec.derived[F, Json, CAAData]
  given codecDNSRecordCAA[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], CAA] =
    Codec.derived[F, Json, CAA]
  given codecDNSRecordCERTData[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], CERTData] =
    Codec.derived[F, Json, CERTData]
  given codecDNSRecordCERT[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], CERT] =
    Codec.derived[F, Json, CERT]
  given codecDNSRecordCNAME[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], CNAME] =
    Codec.derived[F, Json, CNAME]
  given codecDNSRecordDNSKEYData[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], DNSKEYData] =
    Codec.derived[F, Json, DNSKEYData]
  given codecDNSRecordDNSKEY[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], DNSKEY] =
    Codec.derived[F, Json, DNSKEY]
  given codecDNSRecordDSData[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], DSData] =
    Codec.derived[F, Json, DSData]
  given codecDNSRecordDS[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], DS] =
    Codec.derived[F, Json, DS]
  given codecDNSRecordHTTPSData[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], HTTPSData] =
    Codec.derived[F, Json, HTTPSData]
  given codecDNSRecordHTTPS[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], HTTPS] =
    Codec.derived[F, Json, HTTPS]
  given codecDNSRecordLOCData[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], LOCData] =
    Codec.derived[F, Json, LOCData]
  given codecDNSRecordLOC[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], LOC] =
    Codec.derived[F, Json, LOC]
  given codecDNSRecordMX[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], MX] =
    Codec.derived[F, Json, MX]
  given codecDNSRecordNAPTRData[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], NAPTRData] =
    Codec.derived[F, Json, NAPTRData]
  given codecDNSRecordNAPTR[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], NAPTR] =
    Codec.derived[F, Json, NAPTR]
  given codecDNSRecordNS[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], NS] =
    Codec.derived[F, Json, NS]
  given codecDNSRecordPTR[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], PTR] =
    Codec.derived[F, Json, PTR]
  given codecDNSRecordSMIMEAData[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], SMIMEAData] =
    Codec.derived[F, Json, SMIMEAData]
  given codecDNSRecordSMIMEA[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], SMIMEA] =
    Codec.derived[F, Json, SMIMEA]
  given codecDNSRecordSRVData[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], SRVData] =
    Codec.derived[F, Json, SRVData]
  given codecDNSRecordSRV[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], SRV] =
    Codec.derived[F, Json, SRV]
  given codecDNSRecordSSHFPData[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], SSHFPData] =
    Codec.derived[F, Json, SSHFPData]
  given codecDNSRecordSSHFP[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], SSHFP] =
    Codec.derived[F, Json, SSHFP]
  given codecDNSRecordSVCBData[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], SVCBData] =
    Codec.derived[F, Json, SVCBData]
  given codecDNSRecordSVCB[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], SVCB] =
    Codec.derived[F, Json, SVCB]
  given codecDNSRecordTLSAData[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], TLSAData] =
    Codec.derived[F, Json, TLSAData]
  given codecDNSRecordTLSA[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], TLSA] =
    Codec.derived[F, Json, TLSA]
  given codecDNSRecordTXT[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], TXT] =
    Codec.derived[F, Json, TXT]
  given codecDNSRecordURIData[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], URIData] =
    Codec.derived[F, Json, URIData]
  given codecDNSRecordURI[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], URI] =
    Codec.derived[F, Json, URI]
  given codecDNSRecord[F[_]](using configuration: CodecConfiguration, monad: Monad[F])
  : Codec[F, Json, Cursor[Json], DNSRecord] =
    Codec.derived[F, Json, DNSRecord](using configuration.withDiscriminator("type"))
end DNSRecordInstances
object DNSRecordInstances extends DNSRecordInstances
