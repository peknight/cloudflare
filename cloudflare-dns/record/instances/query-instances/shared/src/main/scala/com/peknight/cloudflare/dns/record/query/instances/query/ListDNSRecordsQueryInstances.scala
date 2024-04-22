package com.peknight.cloudflare.dns.record.query.instances.query

import cats.Monad
import com.peknight.cloudflare.codec.instances.query.{DirectionInstances, MatchInstances, OrderInstances}
import com.peknight.cloudflare.dns.record.codec.instances.DNSRecordTypeInstances
import com.peknight.cloudflare.dns.record.query.ListDNSRecordsQuery
import com.peknight.cloudflare.query.instances.query.StringOptionParamInstances
import com.peknight.codec.Codec
import com.peknight.codec.configuration.CodecConfiguration
import com.peknight.codec.cursor.Cursor
import com.peknight.query.Query

trait ListDNSRecordsQueryInstances extends StringOptionParamInstances
  with DirectionInstances
  with MatchInstances
  with OrderInstances
  with DNSRecordTypeInstances:
  given codecListDNSRecordsQuery[F[_]](using CodecConfiguration, Monad[F])
  : Codec[F, Query, Cursor[Query], ListDNSRecordsQuery] =
    Codec.derived[F, Query, ListDNSRecordsQuery]
end ListDNSRecordsQueryInstances
object ListDNSRecordsQueryInstances extends ListDNSRecordsQueryInstances
