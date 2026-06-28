package com.peknight.cloudflare.dns.record

import cats.{Monad, Show}
import com.peknight.cloudflare.config.given
import com.peknight.codec.Codec
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.sum.{NullType, ObjectType, StringType}

case class DNSRecordSettings(ipv4Only: Option[Boolean], ipv6Only: Option[Boolean])
object DNSRecordSettings:
  given codecDNSRecordSettings[F[_]: Monad, S: {ObjectType, NullType, StringType, Show}]
  : Codec[F, S, Cursor[S], DNSRecordSettings] =
    Codec.derived[F, S, DNSRecordSettings]
  given showDNSRecordSettings: Show[DNSRecordSettings] = Show.fromToString[DNSRecordSettings]
end DNSRecordSettings
