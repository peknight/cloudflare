package com.peknight.cloudflare.dns.record

import cats.{Monad, Show}
import com.peknight.cloudflare.config.given
import com.peknight.codec.Codec
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.sum.{NullType, NumberType, ObjectType, StringType}

case class TLSAData(certificate: String, matchingType: Int, selector: Int, usage: Int)
object TLSAData:
  given codecDNSRecordTLSAData[F[_] : Monad, S: {ObjectType, NullType, NumberType, StringType, Show}]
  : Codec[F, S, Cursor[S], TLSAData] =
    Codec.derived[F, S, TLSAData]

  given showDNSRecordTLSAData: Show[TLSAData] = Show.fromToString[TLSAData]
end TLSAData
