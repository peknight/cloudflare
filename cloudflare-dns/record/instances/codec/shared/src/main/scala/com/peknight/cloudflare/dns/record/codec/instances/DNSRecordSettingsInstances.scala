package com.peknight.cloudflare.dns.record.codec.instances

import cats.Monad
import com.peknight.cloudflare.dns.record.DNSRecordSettings
import com.peknight.codec.Codec
import com.peknight.codec.configuration.CodecConfiguration
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.sum.{NullType, ObjectType, StringType}

trait DNSRecordSettingsInstances:
  given codecDNSRecordSettings[F[_], S](using CodecConfiguration, Monad[F], ObjectType[S], NullType[S], StringType[S])
  : Codec[F, S, Cursor[S], DNSRecordSettings] =
    Codec.derived[F, S, DNSRecordSettings]
end DNSRecordSettingsInstances
object DNSRecordSettingsInstances extends DNSRecordSettingsInstances
