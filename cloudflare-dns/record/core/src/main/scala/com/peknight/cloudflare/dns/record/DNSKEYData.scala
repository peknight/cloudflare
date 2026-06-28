package com.peknight.cloudflare.dns.record

import cats.{Monad, Show}
import com.peknight.cloudflare.config.given
import com.peknight.codec.Codec
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.sum.{NullType, NumberType, ObjectType, StringType}

case class DNSKEYData(algorithm: Int, flags: Int, protocol: Int, publicKey: String)
object DNSKEYData:
  given codecDNSRecordDNSKEYData[F[_]: Monad, S: {ObjectType, NullType, NumberType, StringType, Show}]
  : Codec[F, S, Cursor[S], DNSKEYData] =
    Codec.derived[F, S, DNSKEYData]
  given showDNSRecordDNSKEYData: Show[DNSKEYData] = Show.fromToString[DNSKEYData]
end DNSKEYData
