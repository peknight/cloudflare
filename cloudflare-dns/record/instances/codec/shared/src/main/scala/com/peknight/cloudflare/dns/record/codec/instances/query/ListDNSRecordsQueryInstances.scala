package com.peknight.cloudflare.dns.record.codec.instances.query

import cats.Monad
import com.peknight.cloudflare.codec.instances.query.`match`.given
import com.peknight.cloudflare.codec.instances.query.direction.given
import com.peknight.cloudflare.codec.instances.query.order.given
import com.peknight.cloudflare.codec.instances.query.stringOptionParam.given
import com.peknight.cloudflare.dns.record.codec.instances.dnsRecordType.given
import com.peknight.cloudflare.dns.record.query.ListDNSRecordsQuery
import com.peknight.codec.Codec
import com.peknight.codec.config.CodecConfig
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.sum.*

trait ListDNSRecordsQueryInstances:
  given codecListDNSRecordsQuery[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], NumberType[S],
                                          BooleanType[S], StringType[S]): Codec[F, S, Cursor[S], ListDNSRecordsQuery] =
    Codec.derived[F, S, ListDNSRecordsQuery]
end ListDNSRecordsQueryInstances
object ListDNSRecordsQueryInstances extends ListDNSRecordsQueryInstances
