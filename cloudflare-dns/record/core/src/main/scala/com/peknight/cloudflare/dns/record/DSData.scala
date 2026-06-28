package com.peknight.cloudflare.dns.record

import cats.{Monad, Show}
import com.peknight.cloudflare.config.given
import com.peknight.codec.Codec
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.sum.{NullType, NumberType, ObjectType, StringType}

case class DSData(algorithm: Int, digest: String, digestType: Int, keyTag: Int)
object DSData:
  given codecDNSRecordDSData[F[_] : Monad, S: {ObjectType, NullType, NumberType, StringType, Show}]
  : Codec[F, S, Cursor[S], DSData] =
    Codec.derived[F, S, DSData]

  given showDNSRecordDSData: Show[DSData] = Show.fromToString[DSData]
end DSData
