package com.peknight.cloudflare.dns.record

import cats.{Monad, Show}
import com.comcast.ip4s.{Hostname, Port}
import com.peknight.cloudflare.config.given
import com.peknight.codec.Codec
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.ip4s.instances.host.given
import com.peknight.codec.ip4s.instances.port.given
import com.peknight.codec.sum.{NullType, NumberType, ObjectType, StringType}

case class SRVData(port: Port, priority: Int, target: Hostname, weight: Int)
object SRVData:
  given codecDNSRecordSRVData[F[_] : Monad, S: {ObjectType, NullType, NumberType, StringType, Show}]
  : Codec[F, S, Cursor[S], SRVData] =
    Codec.derived[F, S, SRVData]

  given showDNSRecordSRVData: Show[SRVData] = Show.fromToString[SRVData]
end SRVData
