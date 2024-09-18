package com.peknight.cloudflare.dns.record.circe.instances.body

import cats.Monad
import com.peknight.cloudflare.dns.record.body.DNSRecordBody
import com.peknight.cloudflare.dns.record.body.DNSRecordBody.*
import com.peknight.cloudflare.dns.record.codec.instances.body.dnsRecordBody.given
import com.peknight.codec.Codec
import com.peknight.codec.circe.sum.jsonType.given
import com.peknight.codec.configuration.CodecConfiguration
import com.peknight.codec.cursor.Cursor
import io.circe.Json

//noinspection DuplicatedCode
trait DNSRecordBodyInstances:
  given jsonCodecDNSRecordBodyA[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], A] =
    codecDNSRecordBodyA[F, Json]
  given jsonCodecDNSRecordBodyAAAA[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], AAAA] =
    codecDNSRecordBodyAAAA[F, Json]
  given jsonCodecDNSRecordBodyCAA[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], CAA] =
    codecDNSRecordBodyCAA[F, Json]
  given jsonCodecDNSRecordBodyCERT[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], CERT] =
    codecDNSRecordBodyCERT[F, Json]
  given jsonCodecDNSRecordBodyCNAME[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], CNAME] =
    codecDNSRecordBodyCNAME[F, Json]
  given jsonCodecDNSRecordBodyDNSKEY[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], DNSKEY] =
    codecDNSRecordBodyDNSKEY[F, Json]
  given jsonCodecDNSRecordBodyDS[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], DS] =
    codecDNSRecordBodyDS[F, Json]
  given jsonCodecDNSRecordBodyHTTPS[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], HTTPS] =
    codecDNSRecordBodyHTTPS [F, Json]
  given jsonCodecDNSRecordBodyLOC[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], LOC] =
    codecDNSRecordBodyLOC[F, Json]
  given jsonCodecDNSRecordBodyMX[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], MX] =
    codecDNSRecordBodyMX[F, Json]
  given jsonCodecDNSRecordBodyNAPTR[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], NAPTR] =
    codecDNSRecordBodyNAPTR[F, Json]
  given jsonCodecDNSRecordBodyNS[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], NS] =
    codecDNSRecordBodyNS[F, Json]
  given jsonCodecDNSRecordBodyOPENPGPKEY[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], OPENPGPKEY] =
    codecDNSRecordBodyOPENPGPKEY[F, Json]
  given jsonCodecDNSRecordBodyPTR[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], PTR] =
    codecDNSRecordBodyPTR[F, Json]
  given jsonCodecDNSRecordBodySMIMEA[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], SMIMEA] =
    codecDNSRecordBodySMIMEA[F, Json]
  given jsonCodecDNSRecordBodySRV[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], SRV] =
    codecDNSRecordBodySRV[F, Json]
  given jsonCodecDNSRecordBodySSHFP[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], SSHFP] =
    codecDNSRecordBodySSHFP[F, Json]
  given jsonCodecDNSRecordBodySVCB[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], SVCB] =
    codecDNSRecordBodySVCB[F, Json]
  given jsonCodecDNSRecordBodyTLSA[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], TLSA] =
    codecDNSRecordBodyTLSA[F, Json]
  given jsonCodecDNSRecordBodyTXT[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], TXT] =
    codecDNSRecordBodyTXT[F, Json]
  given jsonCodecDNSRecordBodyURI[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], URI] =
    codecDNSRecordBodyURI[F, Json]
  given jsonCodecDNSRecordBody[F[_]](using configuration: CodecConfiguration, monad: Monad[F])
  : Codec[F, Json, Cursor[Json], DNSRecordBody] =
    codecDNSRecordBody[F, Json]
end DNSRecordBodyInstances
object DNSRecordBodyInstances extends DNSRecordBodyInstances
