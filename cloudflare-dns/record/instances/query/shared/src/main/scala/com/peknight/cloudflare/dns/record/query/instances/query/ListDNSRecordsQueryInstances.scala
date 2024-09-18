package com.peknight.cloudflare.dns.record.query.instances.query

import cats.Monad
import com.peknight.cloudflare.dns.record.codec.instances.query.listDNSRecordsQuery.codecListDNSRecordsQuery
import com.peknight.cloudflare.dns.record.query.ListDNSRecordsQuery
import com.peknight.codec.Codec
import com.peknight.codec.configuration.CodecConfiguration
import com.peknight.codec.cursor.Cursor
import com.peknight.query.Query

trait ListDNSRecordsQueryInstances:
  given queryCodecListDNSRecordsQuery[F[_]](using CodecConfiguration, Monad[F])
  : Codec[F, Query, Cursor[Query], ListDNSRecordsQuery] =
    codecListDNSRecordsQuery[F, Query]
end ListDNSRecordsQueryInstances
object ListDNSRecordsQueryInstances extends ListDNSRecordsQueryInstances
