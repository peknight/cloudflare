package com.peknight.cloudflare.dns.record

import cats.{Monad, Show}
import com.peknight.cloudflare.config.given
import com.peknight.codec.Codec
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.sum.{NullType, NumberType, ObjectType, StringType}

case class SSHFPData(algorithm: Int, fingerprint: String, `type`: Int)
object SSHFPData:
  given codecDNSRecordSSHFPData[F[_]: Monad, S: {ObjectType, NullType, NumberType, StringType, Show}]
  : Codec[F, S, Cursor[S], SSHFPData] =
    Codec.derived[F, S, SSHFPData]
  given showDNSRecordSSHFPData: Show[SSHFPData] = Show.fromToString[SSHFPData]
end SSHFPData
