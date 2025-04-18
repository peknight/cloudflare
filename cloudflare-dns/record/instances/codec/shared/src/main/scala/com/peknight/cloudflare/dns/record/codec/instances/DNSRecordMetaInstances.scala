package com.peknight.cloudflare.dns.record.codec.instances

import cats.Monad
import com.peknight.cloudflare.dns.record.DNSRecordMeta
import com.peknight.codec.Codec
import com.peknight.codec.config.CodecConfig
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.sum.{BooleanType, NullType, ObjectType, StringType}

trait DNSRecordMetaInstances:
  given codecDNSRecordMeta[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], BooleanType[S],
                                    StringType[S]): Codec[F, S, Cursor[S], DNSRecordMeta] =
    Codec.derived[F, S, DNSRecordMeta]
end DNSRecordMetaInstances
object DNSRecordMetaInstances extends DNSRecordMetaInstances
