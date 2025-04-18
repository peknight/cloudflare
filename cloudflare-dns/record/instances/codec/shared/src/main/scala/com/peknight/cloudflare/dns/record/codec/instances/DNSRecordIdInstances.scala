package com.peknight.cloudflare.dns.record.codec.instances

import cats.{Applicative, Show}
import com.peknight.cloudflare.dns.record.DNSRecordId
import com.peknight.codec.Codec
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.sum.StringType

trait DNSRecordIdInstances:
  given stringCodecDNSRecordId[F[_]: Applicative]: Codec[F, String, String, DNSRecordId] =
    Codec.map[F, String, String, DNSRecordId](_.id)(DNSRecordId.apply)

  given codecDNSRecordIdS[F[_]: Applicative, S: {StringType, Show}]: Codec[F, S, Cursor[S], DNSRecordId] =
    Codec.codecS[F, S, DNSRecordId]
end DNSRecordIdInstances
object DNSRecordIdInstances extends DNSRecordIdInstances
