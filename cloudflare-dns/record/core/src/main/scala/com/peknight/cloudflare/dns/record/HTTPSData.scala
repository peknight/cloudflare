package com.peknight.cloudflare.dns.record

import cats.{Monad, Show}
import com.peknight.cloudflare.config.given
import com.peknight.codec.Codec
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.sum.{NullType, NumberType, ObjectType, StringType}

case class HTTPSData(priority: Int, target: String, value: String)
object HTTPSData:
  given codecDNSRecordHTTPSData[F[_]: Monad, S: {ObjectType, NullType, NumberType, StringType, Show}]
  : Codec[F, S, Cursor[S], HTTPSData] =
    Codec.derived[F, S, HTTPSData]

  given showDNSRecordHTTPSData: Show[HTTPSData] = Show.fromToString[HTTPSData]
end HTTPSData
