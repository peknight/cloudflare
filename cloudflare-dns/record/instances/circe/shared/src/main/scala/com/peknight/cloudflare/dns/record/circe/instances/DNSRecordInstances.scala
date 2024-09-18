package com.peknight.cloudflare.dns.record.circe.instances

import cats.Monad
import com.peknight.cloudflare.dns.record.*
import com.peknight.cloudflare.dns.record.DNSRecord.*
import com.peknight.cloudflare.dns.record.codec.instances.dnsRecord.given
import com.peknight.codec.Codec
import com.peknight.codec.circe.sum.jsonType.given
import com.peknight.codec.configuration.CodecConfiguration
import com.peknight.codec.cursor.Cursor
import io.circe.Json

//noinspection DuplicatedCode
trait DNSRecordInstances:
  given jsonCodecDNSRecordA[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], A] =
    codecDNSRecordA[F, Json]
  given jsonCodecDNSRecordAAAA[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], AAAA] =
    codecDNSRecordAAAA[F, Json]
  given jsonCodecDNSRecordCAA[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], CAA] =
    codecDNSRecordCAA[F, Json]
  given jsonCodecDNSRecordCERT[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], CERT] =
    codecDNSRecordCERT[F, Json]
  given jsonCodecDNSRecordCNAME[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], CNAME] =
    codecDNSRecordCNAME[F, Json]
  given jsonCodecDNSRecordDNSKEY[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], DNSKEY] =
    codecDNSRecordDNSKEY[F, Json]
  given jsonCodecDNSRecordDS[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], DS] =
    codecDNSRecordDS[F, Json]
  given jsonCodecDNSRecordHTTPS[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], HTTPS] =
    codecDNSRecordHTTPS[F, Json]
  given jsonCodecDNSRecordLOC[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], LOC] =
    codecDNSRecordLOC[F, Json]
  given jsonCodecDNSRecordMX[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], MX] =
    codecDNSRecordMX[F, Json]
  given jsonCodecDNSRecordNAPTR[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], NAPTR] =
    codecDNSRecordNAPTR[F, Json]
  given jsonCodecDNSRecordNS[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], NS] =
    codecDNSRecordNS[F, Json]
  given jsonCodecDNSRecordOPENPGPKEY[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], OPENPGPKEY] =
    codecDNSRecordOPENPGPKEY[F, Json]
  given jsonCodecDNSRecordPTR[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], PTR] =
    codecDNSRecordPTR[F, Json]
  given jsonCodecDNSRecordSMIMEA[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], SMIMEA] =
    codecDNSRecordSMIMEA[F, Json]
  given jsonCodecDNSRecordSRV[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], SRV] =
    codecDNSRecordSRV[F, Json]
  given jsonCodecDNSRecordSSHFP[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], SSHFP] =
    codecDNSRecordSSHFP[F, Json]
  given jsonCodecDNSRecordSVCB[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], SVCB] =
    codecDNSRecordSVCB[F, Json]
  given jsonCodecDNSRecordTLSA[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], TLSA] =
    codecDNSRecordTLSA[F, Json]
  given jsonCodecDNSRecordTXT[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], TXT] =
    codecDNSRecordTXT[F, Json]
  given jsonCodecDNSRecordURI[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], URI] =
    codecDNSRecordURI[F, Json]
  given jsonCodecDNSRecord[F[_]](using configuration: CodecConfiguration, monad: Monad[F])
  : Codec[F, Json, Cursor[Json], DNSRecord] =
    codecDNSRecord[F, Json]
end DNSRecordInstances
object DNSRecordInstances extends DNSRecordInstances
