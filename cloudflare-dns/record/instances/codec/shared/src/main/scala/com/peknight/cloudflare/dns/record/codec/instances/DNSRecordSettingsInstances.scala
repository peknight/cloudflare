package com.peknight.cloudflare.dns.record.codec.instances

import cats.{Monad, Show}
import com.peknight.cloudflare.dns.record.DNSRecordSettings
import com.peknight.codec.Codec
import com.peknight.codec.config.CodecConfig
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.sum.{NullType, ObjectType, StringType}
import com.peknight.generic.derivation.show

trait DNSRecordSettingsInstances:
  given codecDNSRecordSettings[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], StringType[S], Show[S])
  : Codec[F, S, Cursor[S], DNSRecordSettings] =
    Codec.derived[F, S, DNSRecordSettings]
  given showDNSRecordSettings: Show[DNSRecordSettings] = show.derived[DNSRecordSettings]  
end DNSRecordSettingsInstances
object DNSRecordSettingsInstances extends DNSRecordSettingsInstances
