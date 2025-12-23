package com.peknight.cloudflare.dns.record

import cats.{Monad, Show}
import com.peknight.cloudflare.config.given
import com.peknight.codec.Codec
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.sum.{BooleanType, NullType, ObjectType, StringType}

case class DNSRecordMeta(autoAdded: Option[Boolean], managedByApps: Option[Boolean],
                         managedByArgoTunnel: Option[Boolean], source: Option[String])
object DNSRecordMeta:
  given codecDNSRecordMeta[F[_]: Monad, S: {ObjectType, NullType, BooleanType, StringType, Show}]
  : Codec[F, S, Cursor[S], DNSRecordMeta] =
    Codec.derived[F, S, DNSRecordMeta]
  given showDNSRecordMeta: Show[DNSRecordMeta] = Show.fromToString[DNSRecordMeta]
end DNSRecordMeta
