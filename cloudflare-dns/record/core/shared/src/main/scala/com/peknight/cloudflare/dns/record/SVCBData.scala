package com.peknight.cloudflare.dns.record

import cats.{Monad, Show}
import com.peknight.cloudflare.config.given
import com.peknight.codec.Codec
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.sum.{NullType, NumberType, ObjectType, StringType}

case class SVCBData(priority: Int, target: String, value: String)
object SVCBData:
  given codecDNSRecordSVCBData[F[_] : Monad, S: {ObjectType, NullType, NumberType, StringType, Show}]
  : Codec[F, S, Cursor[S], SVCBData] =
    Codec.derived[F, S, SVCBData]

  given showDNSRecordSVCBData: Show[SVCBData] = Show.fromToString[SVCBData]
end SVCBData
