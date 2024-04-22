package com.peknight.cloudflare.dns.record.query

import com.peknight.cloudflare.dns.record.DNSRecordType
import com.peknight.cloudflare.query.{Direction, Match, QueryParam, StringOptionParam}

case class ListDNSRecordsQuery(comment: Option[StringOptionParam] = None, content: Option[String] = None,
                               direction: Option[Direction] = None, `match`: Option[Match] = None,
                               name: Option[String] = None, order: Option[Order] = None, page: Option[Int] = None,
                               perPage: Option[Int] = None, proxied: Option[Boolean] = None,
                               search: Option[String] = None, tag: Option[StringOptionParam] = None,
                               tagMatch: Option[Match] = None, `type`: Option[DNSRecordType] = None) extends QueryParam