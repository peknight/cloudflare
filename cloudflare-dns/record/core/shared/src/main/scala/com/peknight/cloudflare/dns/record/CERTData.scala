package com.peknight.cloudflare.dns.record

import cats.{Monad, Show}
import com.peknight.cloudflare.config.given
import com.peknight.codec.Codec
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.sum.{NullType, NumberType, ObjectType, StringType}

case class CERTData(algorithm: Int, certificate: String, keyTag: Int, `type`: Int)
object CERTData:
  given codecDNSRecordCERTData[F[_] : Monad, S: {ObjectType, NullType, NumberType, StringType, Show}]
  : Codec[F, S, Cursor[S], CERTData] =
    Codec.derived[F, S, CERTData]

  given showDNSRecordCERTData: Show[CERTData] = Show.fromToString[CERTData]
end CERTData
