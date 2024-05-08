package com.peknight.cloudflare.dns.record.codec.instances

import cats.Applicative
import cats.syntax.applicative.*
import com.peknight.cloudflare.dns.record.DNSRecordId
import com.peknight.codec.Codec
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.sum.{ObjectType, StringType}

trait DNSRecordIdObjectInstances:
  given codecDNSRecordIdObjectS[F[_], S](using applicative: Applicative[F], objectType: ObjectType[S],
                                         stringType: StringType[S]): Codec[F, S, Cursor[S], DNSRecordId] =
    val key = "id"
    Codec.cursor[F, S, DNSRecordId](id => objectType.to(objectType.singleton(key, stringType.to(id.id))).pure[F]) {
      cursor => DNSRecordIdInstances.codecDNSRecordIdS[F, S].decode(cursor.downField(key))
    }
end DNSRecordIdObjectInstances
