package com.peknight.cloudflare.dns.record.query.instances.query

import cats.Monad
import com.peknight.cloudflare.codec.instances.query.`match`.given
import com.peknight.cloudflare.codec.instances.query.direction.given
import com.peknight.cloudflare.codec.instances.query.order.given
import com.peknight.cloudflare.dns.record.codec.instances.dnsRecordType.given
import com.peknight.cloudflare.dns.record.query.ListDNSRecordsQuery
import com.peknight.cloudflare.query.instances.query.stringOptionParam.given
import com.peknight.codec.Codec
import com.peknight.codec.configuration.CodecConfiguration
import com.peknight.codec.cursor.Cursor
import com.peknight.query.Query

trait ListDNSRecordsQueryInstances:
  given codecListDNSRecordsQuery[F[_]](using CodecConfiguration, Monad[F])
  : Codec[F, Query, Cursor[Query], ListDNSRecordsQuery] =
    Codec.derived[F, Query, ListDNSRecordsQuery]
end ListDNSRecordsQueryInstances
object ListDNSRecordsQueryInstances extends ListDNSRecordsQueryInstances
