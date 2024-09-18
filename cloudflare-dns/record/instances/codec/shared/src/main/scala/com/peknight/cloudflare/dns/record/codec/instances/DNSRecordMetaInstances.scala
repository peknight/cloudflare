package com.peknight.cloudflare.dns.record.codec.instances

import cats.Monad
import com.peknight.cloudflare.dns.record.DNSRecordMeta
import com.peknight.codec.Codec
import com.peknight.codec.configuration.CodecConfiguration
import com.peknight.codec.cursor.Cursor

trait DNSRecordMetaInstances:
  given codecDNSRecordMeta[F[_], S](using CodecConfiguration, Monad[F], ObjectType[S], NullType[S], BooleanType[S],
                                    StringType[S]): Codec[F, S, Cursor[S], DNSRecordMeta] =
    Codec.derived[F, S, DNSRecordMeta]
end DNSRecordMetaInstances
object DNSRecordMetaInstances extends DNSRecordMetaInstances
