package com.peknight.cloudflare.dns.record

import cats.{Monad, Show}
import com.peknight.cloudflare.config.given
import com.peknight.cloudflare.dns.record.DNSRecord.*
import com.peknight.codec.Codec
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.instances.time.finiteDuration.codecFiniteDurationOfSecondsNS
import com.peknight.codec.ip4s.instances.host.given
import com.peknight.codec.sum.*

import scala.concurrent.duration.FiniteDuration

//noinspection DuplicatedCode
trait DNSRecordCompanion:
  given codecDNSRecordA[F[_]: Monad, S: {ObjectType, NullType, ArrayType, NumberType, BooleanType, StringType, Show}]
  : Codec[F, S, Cursor[S], A] =
    given Codec[F, S, Cursor[S], DNSRecordId] = DNSRecordId.codecDNSRecordIdS
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, A]
  given codecDNSRecordAAAA[F[_]: Monad, S: {ObjectType, NullType, ArrayType, NumberType, BooleanType, StringType, Show}]
  : Codec[F, S, Cursor[S], AAAA] =
    given Codec[F, S, Cursor[S], DNSRecordId] = DNSRecordId.codecDNSRecordIdS
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, AAAA]
  given codecDNSRecordCAA[F[_]: Monad, S: {ObjectType, NullType, ArrayType, NumberType, BooleanType, StringType, Show}]
  : Codec[F, S, Cursor[S], CAA] =
    given Codec[F, S, Cursor[S], DNSRecordId] = DNSRecordId.codecDNSRecordIdS
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, CAA]
  given codecDNSRecordCERT[F[_]: Monad, S: {ObjectType, NullType, ArrayType, NumberType, BooleanType, StringType, Show}]
  : Codec[F, S, Cursor[S], CERT] =
    given Codec[F, S, Cursor[S], DNSRecordId] = DNSRecordId.codecDNSRecordIdS
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, CERT]
  given codecDNSRecordCNAME[F[_]: Monad, S: {ObjectType, NullType, ArrayType, NumberType, BooleanType, StringType, Show}]
  : Codec[F, S, Cursor[S], CNAME] =
    given Codec[F, S, Cursor[S], DNSRecordId] = DNSRecordId.codecDNSRecordIdS
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, CNAME]
  given codecDNSRecordDNSKEY[F[_]: Monad, S: {ObjectType, NullType, ArrayType, NumberType, BooleanType, StringType, Show}]
  : Codec[F, S, Cursor[S], DNSKEY] =
    given Codec[F, S, Cursor[S], DNSRecordId] = DNSRecordId.codecDNSRecordIdS
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, DNSKEY]
  given codecDNSRecordDS[F[_]: Monad, S: {ObjectType, NullType, ArrayType, NumberType, BooleanType, StringType, Show}]
  : Codec[F, S, Cursor[S], DS] =
    given Codec[F, S, Cursor[S], DNSRecordId] = DNSRecordId.codecDNSRecordIdS
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, DS]
  given codecDNSRecordHTTPS[F[_]: Monad, S: {ObjectType, NullType, ArrayType, NumberType, BooleanType, StringType, Show}]
  : Codec[F, S, Cursor[S], HTTPS] =
    given Codec[F, S, Cursor[S], DNSRecordId] = DNSRecordId.codecDNSRecordIdS
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, HTTPS]
  given codecDNSRecordLOC[F[_]: Monad, S: {ObjectType, NullType, ArrayType, NumberType, BooleanType, StringType, Show}]
  : Codec[F, S, Cursor[S], LOC] =
    given Codec[F, S, Cursor[S], DNSRecordId] = DNSRecordId.codecDNSRecordIdS
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, LOC]
  given codecDNSRecordMX[F[_]: Monad, S: {ObjectType, NullType, ArrayType, NumberType, BooleanType, StringType, Show}]
  : Codec[F, S, Cursor[S], MX] =
    given Codec[F, S, Cursor[S], DNSRecordId] = DNSRecordId.codecDNSRecordIdS
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, MX]
  given codecDNSRecordNAPTR[F[_]: Monad, S: {ObjectType, NullType, ArrayType, NumberType, BooleanType, StringType, Show}]
  : Codec[F, S, Cursor[S], NAPTR] =
    given Codec[F, S, Cursor[S], DNSRecordId] = DNSRecordId.codecDNSRecordIdS
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, NAPTR]
  given codecDNSRecordNS[F[_]: Monad, S: {ObjectType, NullType, ArrayType, NumberType, BooleanType, StringType, Show}]
  : Codec[F, S, Cursor[S], NS] =
    given Codec[F, S, Cursor[S], DNSRecordId] = DNSRecordId.codecDNSRecordIdS
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, NS]
  given codecDNSRecordOPENPGPKEY[F[_]: Monad, S: {ObjectType, NullType, ArrayType, NumberType, BooleanType, StringType, Show}]
  : Codec[F, S, Cursor[S], OPENPGPKEY] =
    given Codec[F, S, Cursor[S], DNSRecordId] = DNSRecordId.codecDNSRecordIdS
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, OPENPGPKEY]
  given codecDNSRecordPTR[F[_]: Monad, S: {ObjectType, NullType, ArrayType, NumberType, BooleanType, StringType, Show}]
  : Codec[F, S, Cursor[S], PTR] =
    given Codec[F, S, Cursor[S], DNSRecordId] = DNSRecordId.codecDNSRecordIdS
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, PTR]
  given codecDNSRecordSMIMEA[F[_]: Monad, S: {ObjectType, NullType, ArrayType, NumberType, BooleanType, StringType, Show}]
  : Codec[F, S, Cursor[S], SMIMEA] =
    given Codec[F, S, Cursor[S], DNSRecordId] = DNSRecordId.codecDNSRecordIdS
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, SMIMEA]
  given codecDNSRecordSRV[F[_]: Monad, S: {ObjectType, NullType, ArrayType, NumberType, BooleanType, StringType, Show}]
  : Codec[F, S, Cursor[S], SRV] =
    given Codec[F, S, Cursor[S], DNSRecordId] = DNSRecordId.codecDNSRecordIdS
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, SRV]
  given codecDNSRecordSSHFP[F[_]: Monad, S: {ObjectType, NullType, ArrayType, NumberType, BooleanType, StringType, Show}]
  : Codec[F, S, Cursor[S], SSHFP] =
    given Codec[F, S, Cursor[S], DNSRecordId] = DNSRecordId.codecDNSRecordIdS
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, SSHFP]
  given codecDNSRecordSVCB[F[_]: Monad, S: {ObjectType, NullType, ArrayType, NumberType, BooleanType, StringType, Show}]
  : Codec[F, S, Cursor[S], SVCB] =
    given Codec[F, S, Cursor[S], DNSRecordId] = DNSRecordId.codecDNSRecordIdS
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, SVCB]
  given codecDNSRecordTLSA[F[_]: Monad, S: {ObjectType, NullType, ArrayType, NumberType, BooleanType, StringType, Show}]
  : Codec[F, S, Cursor[S], TLSA] =
    given Codec[F, S, Cursor[S], DNSRecordId] = DNSRecordId.codecDNSRecordIdS
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, TLSA]
  given codecDNSRecordTXT[F[_]: Monad, S: {ObjectType, NullType, ArrayType, NumberType, BooleanType, StringType, Show}]
  : Codec[F, S, Cursor[S], TXT] =
    given Codec[F, S, Cursor[S], DNSRecordId] = DNSRecordId.codecDNSRecordIdS
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, TXT]
  given codecDNSRecordURI[F[_]: Monad, S: {ObjectType, NullType, ArrayType, NumberType, BooleanType, StringType, Show}]
  : Codec[F, S, Cursor[S], URI] =
    given Codec[F, S, Cursor[S], DNSRecordId] = DNSRecordId.codecDNSRecordIdS
    given Codec[F, S, Cursor[S], FiniteDuration] = codecFiniteDurationOfSecondsNS
    Codec.derived[F, S, URI]
  given codecDNSRecord[F[_]: Monad, S: {ObjectType, NullType, ArrayType, NumberType, BooleanType, StringType, Show}]
  : Codec[F, S, Cursor[S], DNSRecord] =
    Codec.derived[F, S, DNSRecord](using codecConfig.withDiscriminator("type"))

  given showDNSRecordA: Show[A] = Show.fromToString[A]
  given showDNSRecordAAAA: Show[AAAA] = Show.fromToString[AAAA]
  given showDNSRecordCAA: Show[CAA] = Show.fromToString[CAA]
  given showDNSRecordCERT: Show[CERT] = Show.fromToString[CERT]
  given showDNSRecordCNAME: Show[CNAME] = Show.fromToString[CNAME]
  given showDNSRecordDNSKEY: Show[DNSKEY] = Show.fromToString[DNSKEY]
  given showDNSRecordDS: Show[DS] = Show.fromToString[DS]
  given showDNSRecordHTTPS: Show[HTTPS] = Show.fromToString[HTTPS]
  given showDNSRecordLOC: Show[LOC] = Show.fromToString[LOC]
  given showDNSRecordMX: Show[MX] = Show.fromToString[MX]
  given showDNSRecordNAPTR: Show[NAPTR] = Show.fromToString[NAPTR]
  given showDNSRecordNS: Show[NS] = Show.fromToString[NS]
  given showDNSRecordOPENPGPKEY: Show[OPENPGPKEY] = Show.fromToString[OPENPGPKEY]
  given showDPTRRecordPTR: Show[PTR] = Show.fromToString[PTR]
  given showDSMIMEARecordSMIMEA: Show[SMIMEA] = Show.fromToString[SMIMEA]
  given showDSRVRecordSRV: Show[SRV] = Show.fromToString[SRV]
  given showDSSHFPRecordSSHFP: Show[SSHFP] = Show.fromToString[SSHFP]
  given showDSVCBRecordSVCB: Show[SVCB] = Show.fromToString[SVCB]
  given showDTLSARecordTLSA: Show[TLSA] = Show.fromToString[TLSA]
  given showDTXTRecordTXT: Show[TXT] = Show.fromToString[TXT]
  given showDNSRecordURI: Show[URI] = Show.fromToString[URI]
  given showDNSRecord: Show[DNSRecord] = Show.fromToString[DNSRecord]
end DNSRecordCompanion
