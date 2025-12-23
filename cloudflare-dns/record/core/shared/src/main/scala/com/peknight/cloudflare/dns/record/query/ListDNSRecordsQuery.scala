package com.peknight.cloudflare.dns.record.query

import cats.{Monad, Show}
import com.peknight.cloudflare.config.given
import com.peknight.cloudflare.dns.record.DNSRecordType
import com.peknight.cloudflare.query.{Direction, Match, QueryParam, StringOptionParam}
import com.peknight.codec.Codec
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.sum.*

case class ListDNSRecordsQuery(comment: Option[StringOptionParam] = None, content: Option[String] = None,
                               direction: Option[Direction] = None, `match`: Option[Match] = None,
                               name: Option[String] = None, order: Option[Order] = None, page: Option[Int] = None,
                               perPage: Option[Int] = None, proxied: Option[Boolean] = None,
                               search: Option[String] = None, tag: Option[StringOptionParam] = None,
                               tagMatch: Option[Match] = None, `type`: Option[DNSRecordType] = None) extends QueryParam
object ListDNSRecordsQuery:
  given codecListDNSRecordsQuery[F[_]: Monad, S: {ObjectType, NullType, NumberType, BooleanType, StringType, Show}]
  : Codec[F, S, Cursor[S], ListDNSRecordsQuery] =
    Codec.derived[F, S, ListDNSRecordsQuery]
  given showListDNSRecordsQuery: Show[ListDNSRecordsQuery] = Show.fromToString[ListDNSRecordsQuery]
end ListDNSRecordsQuery
