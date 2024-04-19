package com.peknight.cloudflare.dns.record.codec.instances

import cats.Applicative
import com.peknight.cloudflare.dns.record.DNSRecordType
import com.peknight.codec.Codec
import com.peknight.codec.configuration.Configuration
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.derivation.EnumCodecDerivation
import com.peknight.codec.sum.StringType

trait DNSRecordTypeInstances:
  given stringCodecDNSRecordType[F[_]](using Configuration, Applicative[F]): Codec[F, String, String, DNSRecordType] =
    EnumCodecDerivation.unsafeDerived[F, String, String, DNSRecordType]

  given codecDNSRecordTypeS[F[_], S](using Configuration, Applicative[F], StringType[S])
  : Codec[F, S, Cursor[S], DNSRecordType] =
    Codec.codecS[F, S, DNSRecordType]
end DNSRecordTypeInstances
object DNSRecordTypeInstances extends DNSRecordTypeInstances
