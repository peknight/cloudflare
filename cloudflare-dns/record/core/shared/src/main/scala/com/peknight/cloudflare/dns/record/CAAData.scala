package com.peknight.cloudflare.dns.record

import cats.{Monad, Show}
import com.peknight.cloudflare.config.given
import com.peknight.codec.Codec
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.sum.{NullType, NumberType, ObjectType, StringType}

case class CAAData(flags: Int, tag: String, value: String)
object CAAData:
  given codecDNSRecordCAAData[F[_]: Monad, S: {ObjectType, NullType, NumberType, StringType, Show}]
  : Codec[F, S, Cursor[S], CAAData] =
    Codec.derived[F, S, CAAData]
  given showDNSRecordCAAData: Show[CAAData] = Show.fromToString[CAAData]
end CAAData
