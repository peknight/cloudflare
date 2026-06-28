package com.peknight.cloudflare.dns.record

import cats.{Applicative, Eq, Show}
import com.peknight.cloudflare.config.given
import com.peknight.codec.Codec
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.derivation.EnumCodecDerivation
import com.peknight.codec.sum.StringType

enum DNSRecordType derives CanEqual:
  case A, AAAA, CAA, CERT, CNAME, DNSKEY, DS, HTTPS, LOC, MX, NAPTR, NS, OPENPGPKEY, PTR, SMIMEA, SRV, SSHFP, SVCB, TLSA, TXT, URI
end DNSRecordType
object DNSRecordType:
  given stringCodecDNSRecordType[F[_]: Applicative]: Codec[F, String, String, DNSRecordType] =
    EnumCodecDerivation.unsafeDerived[F, String, String, DNSRecordType]

  given codecDNSRecordTypeS[F[_]: Applicative, S: {StringType, Show}]: Codec[F, S, Cursor[S], DNSRecordType] =
    Codec.codecS[F, S, DNSRecordType]

  given eqDNSRecordType: Eq[DNSRecordType] = Eq.fromUniversalEquals[DNSRecordType]
  given showDNSRecordType: Show[DNSRecordType] = Show.fromToString[DNSRecordType]
end DNSRecordType
