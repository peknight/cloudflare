package com.peknight.cloudflare.dns.record.circe.instances.body

import cats.Monad
import com.peknight.cloudflare.dns.record.body.DNSRecordBody
import com.peknight.cloudflare.dns.record.body.DNSRecordBody.*
import com.peknight.cloudflare.dns.record.circe.instances.data.given
import com.peknight.cloudflare.dns.record.codec.instances.dnsRecordType.given
import com.peknight.codec.Codec
import com.peknight.codec.circe.sum.jsonType.given
import com.peknight.codec.configuration.CodecConfiguration
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.ip4s.instances.host.given
import io.circe.Json

trait DNSRecordBodyInstances:
  given codecDNSRecordBodyA[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], A] =
    Codec.derived[F, Json, A]
  given codecDNSRecordBodyAAAA[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], AAAA] =
    Codec.derived[F, Json, AAAA]
  given codecDNSRecordBodyCAA[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], CAA] =
    Codec.derived[F, Json, CAA]
  given codecDNSRecordBodyCERT[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], CERT] =
    Codec.derived[F, Json, CERT]
  given codecDNSRecordBodyCNAME[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], CNAME] =
    Codec.derived[F, Json, CNAME]
  given codecDNSRecordBodyDNSKEY[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], DNSKEY] =
    Codec.derived[F, Json, DNSKEY]
  given codecDNSRecordBodyDS[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], DS] =
    Codec.derived[F, Json, DS]
  given codecDNSRecordBodyHTTPS[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], HTTPS] =
    Codec.derived[F, Json, HTTPS]
  given codecDNSRecordBodyLOC[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], LOC] =
    Codec.derived[F, Json, LOC]
  given codecDNSRecordBodyMX[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], MX] =
    Codec.derived[F, Json, MX]
  given codecDNSRecordBodyNAPTR[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], NAPTR] =
    Codec.derived[F, Json, NAPTR]
  given codecDNSRecordBodyNS[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], NS] =
    Codec.derived[F, Json, NS]
  given codecDNSRecordBodyPTR[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], PTR] =
    Codec.derived[F, Json, PTR]
  given codecDNSRecordBodySMIMEA[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], SMIMEA] =
    Codec.derived[F, Json, SMIMEA]
  given codecDNSRecordBodySRV[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], SRV] =
    Codec.derived[F, Json, SRV]
  given codecDNSRecordBodySSHFP[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], SSHFP] =
    Codec.derived[F, Json, SSHFP]
  given codecDNSRecordBodySVCB[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], SVCB] =
    Codec.derived[F, Json, SVCB]
  given codecDNSRecordBodyTLSA[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], TLSA] =
    Codec.derived[F, Json, TLSA]
  given codecDNSRecordBodyTXT[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], TXT] =
    Codec.derived[F, Json, TXT]
  given codecDNSRecordBodyURI[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], URI] =
    Codec.derived[F, Json, URI]
  given codecDNSRecordBody[F[_]](using configuration: CodecConfiguration, monad: Monad[F])
  : Codec[F, Json, Cursor[Json], DNSRecordBody] =
    Codec.derived[F, Json, DNSRecordBody](using configuration.withDiscriminator("type"))
end DNSRecordBodyInstances
object DNSRecordBodyInstances extends DNSRecordBodyInstances
