package com.peknight.cloudflare.dns.record

import cats.{Monad, Show}
import com.peknight.cloudflare.config.given
import com.peknight.codec.Codec
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.sum.{NullType, NumberType, ObjectType, StringType}

case class SMIMEAData(certificate: String, matchingType: Int, selector: Int, usage: Int)
object SMIMEAData:
  given codecDNSRecordSMIMEAData[F[_] : Monad, S: {ObjectType, NullType, NumberType, StringType, Show}]
  : Codec[F, S, Cursor[S], SMIMEAData] =
    Codec.derived[F, S, SMIMEAData]

  given showDNSRecordSMIMEAData: Show[SMIMEAData] = Show.fromToString[SMIMEAData]
end SMIMEAData
