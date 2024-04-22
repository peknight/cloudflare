package com.peknight.cloudflare.dns.record.circe.instances

import cats.Monad
import com.peknight.cloudflare.dns.record.*
import com.peknight.cloudflare.dns.record.DNSRecord.*
import com.peknight.cloudflare.dns.record.codec.instances.{DNSRecordIdInstances, DNSRecordTypeInstances}
import com.peknight.cloudflare.zone.codec.instances.ZoneIdInstances
import com.peknight.codec.Codec
import com.peknight.codec.configuration.CodecConfiguration
import com.peknight.codec.cursor.Cursor
import io.circe.Json

trait DNSRecordInstances extends DNSRecordIdInstances
  with DNSRecordTypeInstances
  with DataInstances
  with ZoneIdInstances:
  given codecDNSRecordMeta[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], DNSRecordMeta] =
    Codec.derived[F, Json, DNSRecordMeta]

  given codecDNSRecordA[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], A] =
    Codec.derived[F, Json, A]
  given codecDNSRecordAAAA[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], AAAA] =
    Codec.derived[F, Json, AAAA]
  given codecDNSRecordCAA[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], CAA] =
    Codec.derived[F, Json, CAA]
  given codecDNSRecordCERT[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], CERT] =
    Codec.derived[F, Json, CERT]
  given codecDNSRecordCNAME[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], CNAME] =
    Codec.derived[F, Json, CNAME]
  given codecDNSRecordDNSKEY[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], DNSKEY] =
    Codec.derived[F, Json, DNSKEY]
  given codecDNSRecordDS[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], DS] =
    Codec.derived[F, Json, DS]
  given codecDNSRecordHTTPS[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], HTTPS] =
    Codec.derived[F, Json, HTTPS]
  given codecDNSRecordLOC[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], LOC] =
    Codec.derived[F, Json, LOC]
  given codecDNSRecordMX[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], MX] =
    Codec.derived[F, Json, MX]
  given codecDNSRecordNAPTR[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], NAPTR] =
    Codec.derived[F, Json, NAPTR]
  given codecDNSRecordNS[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], NS] =
    Codec.derived[F, Json, NS]
  given codecDNSRecordPTR[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], PTR] =
    Codec.derived[F, Json, PTR]
  given codecDNSRecordSMIMEA[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], SMIMEA] =
    Codec.derived[F, Json, SMIMEA]
  given codecDNSRecordSRV[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], SRV] =
    Codec.derived[F, Json, SRV]
  given codecDNSRecordSSHFP[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], SSHFP] =
    Codec.derived[F, Json, SSHFP]
  given codecDNSRecordSVCB[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], SVCB] =
    Codec.derived[F, Json, SVCB]
  given codecDNSRecordTLSA[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], TLSA] =
    Codec.derived[F, Json, TLSA]
  given codecDNSRecordTXT[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], TXT] =
    Codec.derived[F, Json, TXT]
  given codecDNSRecordURI[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], URI] =
    Codec.derived[F, Json, URI]
  given codecDNSRecord[F[_]](using configuration: CodecConfiguration, monad: Monad[F])
  : Codec[F, Json, Cursor[Json], DNSRecord] =
    Codec.derived[F, Json, DNSRecord](using configuration.withDiscriminator("type"))
end DNSRecordInstances
object DNSRecordInstances extends DNSRecordInstances
