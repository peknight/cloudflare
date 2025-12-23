package com.peknight.cloudflare.dns.record

import cats.{Monad, Show}
import com.peknight.cloudflare.config.given
import com.peknight.codec.Codec
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.sum.{NullType, NumberType, ObjectType, StringType}

case class URIData(content: String, weight: Int)
object URIData:
  given codecDNSRecordURIData[F[_]: Monad, S: {ObjectType, NullType, NumberType, StringType, Show}]
  : Codec[F, S, Cursor[S], URIData] =
    Codec.derived[F, S, URIData]
  given showDNSRecordURIData: Show[URIData] = Show.fromToString[URIData]
end URIData
