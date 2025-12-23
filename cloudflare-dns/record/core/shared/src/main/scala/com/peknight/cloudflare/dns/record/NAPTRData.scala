package com.peknight.cloudflare.dns.record

import cats.{Monad, Show}
import com.peknight.cloudflare.config.given
import com.peknight.codec.Codec
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.sum.{NullType, NumberType, ObjectType, StringType}

case class NAPTRData(flags: String, order: Int, preference: Int, regex: String, replacement: String, service: String)
object NAPTRData:
  given codecDNSRecordNAPTRData[F[_] : Monad, S: {ObjectType, NullType, NumberType, StringType, Show}]
  : Codec[F, S, Cursor[S], NAPTRData] =
    Codec.derived[F, S, NAPTRData]

  given showDNSRecordNAPTRData: Show[NAPTRData] = Show.fromToString[NAPTRData]
end NAPTRData
