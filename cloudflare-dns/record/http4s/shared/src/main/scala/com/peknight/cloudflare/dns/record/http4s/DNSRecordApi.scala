package com.peknight.cloudflare.dns.record.http4s

import cats.Id
import cats.effect.Concurrent
import com.peknight.cloudflare.circe.instances.result.given
import com.peknight.cloudflare.codec.instances.configuration.given
import com.peknight.cloudflare.dns.record.body.OverwriteDNSRecordBody
import com.peknight.cloudflare.dns.record.circe.instances.dnsRecord.given
import com.peknight.cloudflare.dns.record.query.ListDNSRecordsQuery
import com.peknight.cloudflare.dns.record.{DNSRecord, DNSRecordId, api}
import com.peknight.cloudflare.http4s.headers.toHeader
import com.peknight.cloudflare.http4s.uri.clientV4
import com.peknight.cloudflare.query.instances.configuration.given
import com.peknight.cloudflare.zone.ZoneId
import com.peknight.cloudflare.{Result, Token}
import com.peknight.codec.Encoder
import com.peknight.codec.http4s.circe.instances.entityDecoder.given
import com.peknight.codec.http4s.circe.instances.entityEncoder.given
import com.peknight.codec.http4s.instances.segmentEncoder.given
import com.peknight.query.Query
import com.peknight.query.http4s.syntax.id.uri.withQuery
import io.circe.Json
import org.http4s.Headers
import org.http4s.Method.{GET, PUT}
import org.http4s.client.Client
import org.http4s.client.dsl.Http4sClientDsl

class DNSRecordApi[F[_]: Concurrent](client: Client[F])(dsl: Http4sClientDsl[F]) extends api.DNSRecordApi[F]:
  import dsl.*
  def listDNSRecords(zoneId: ZoneId)(query: ListDNSRecordsQuery)(token: Token): F[Result[List[DNSRecord]]] =
    given Encoder[Id, Query, ListDNSRecordsQuery] = Encoder.derived[Id, Query, ListDNSRecordsQuery]
    client.run(GET((clientV4 / "zones" / zoneId / "dns_records").withQuery[ListDNSRecordsQuery](query),
        Headers(token.toHeader)))
      .use(_.as[Result[List[DNSRecord]]])

  def overwriteDNSRecord(zoneId: ZoneId, dnsRecordId: DNSRecordId)(body: OverwriteDNSRecordBody)(token: Token)
  : F[Result[DNSRecord]] =
    given Encoder[Id, Json, OverwriteDNSRecordBody] = Encoder.derived[Id, Json, OverwriteDNSRecordBody]
    client.run(PUT(body, clientV4 / "zones" / zoneId / "dns_records" / dnsRecordId, Headers(token.toHeader)))
      .use(_.as[Result[DNSRecord]])
end DNSRecordApi
