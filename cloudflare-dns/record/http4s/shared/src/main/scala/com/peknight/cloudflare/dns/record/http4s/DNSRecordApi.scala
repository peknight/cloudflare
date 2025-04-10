package com.peknight.cloudflare.dns.record.http4s

import cats.Id
import cats.effect.Concurrent
import com.peknight.auth.http4s.syntax.token.toHeader
import com.peknight.auth.token.Token
import com.peknight.cloudflare.Result
import com.peknight.cloudflare.circe.instances.result.given
import com.peknight.cloudflare.codec.instances.configuration.given
import com.peknight.cloudflare.dns.record.body.DNSRecordBody
import com.peknight.cloudflare.dns.record.circe.instances.body.dnsRecordBody.given
import com.peknight.cloudflare.dns.record.circe.instances.dnsRecord.given
import com.peknight.cloudflare.dns.record.codec.instances.dnsRecordId.{codecDNSRecordIdS, stringCodecDNSRecordId}
import com.peknight.cloudflare.dns.record.codec.instances.dnsRecordIdObject.codecDNSRecordIdObjectS
import com.peknight.cloudflare.dns.record.query.ListDNSRecordsQuery
import com.peknight.cloudflare.dns.record.query.instances.query.listDNSRecordsQuery.given
import com.peknight.cloudflare.dns.record.{DNSRecord, DNSRecordId, api}
import com.peknight.cloudflare.http4s.uri.clientV4
import com.peknight.cloudflare.query.instances.configuration.given
import com.peknight.cloudflare.zone.ZoneId
import com.peknight.cloudflare.zone.codec.instances.zoneId.given
import com.peknight.codec.circe.sum.jsonType.given
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.http4s.circe.instances.entityDecoder.given
import com.peknight.codec.http4s.circe.instances.entityEncoder.given
import com.peknight.codec.http4s.instances.segmentEncoder.given
import com.peknight.codec.{Decoder, Encoder}
import com.peknight.query.http4s.syntax.id.uri.withQuery
import io.circe.Json
import org.http4s.Method.{DELETE, GET, PATCH, POST, PUT}
import org.http4s.client.Client
import org.http4s.client.dsl.Http4sClientDsl
import org.http4s.{Headers, Uri}

class DNSRecordApi[F[_]: Concurrent](token: Token)(using client: Client[F]) extends api.DNSRecordApi[F]:
  private val dsl: Http4sClientDsl[F] = Http4sClientDsl[F]
  import dsl.*

  private def dnsRecordsUri(zoneId: ZoneId): Uri = clientV4 / "zones" / zoneId / "dns_records"
  private val headers = Headers(token.toHeader)

  given dnsRecordIdJsonEncoder: Encoder[Id, Json, DNSRecordId] = codecDNSRecordIdS[Id, Json]
  given dnsRecordIdStringEncoder: Encoder[Id, String, DNSRecordId] = stringCodecDNSRecordId[Id]

  def listDNSRecords(zoneId: ZoneId)(query: ListDNSRecordsQuery): F[Result[List[DNSRecord]]] =
    client.run(GET(dnsRecordsUri(zoneId).withQuery[ListDNSRecordsQuery](query), headers))
      .use(_.as[Result[List[DNSRecord]]])

  def createDNSRecord(zoneId: ZoneId)(body: DNSRecordBody): F[Result[DNSRecord]] =
    client.run(POST(body, dnsRecordsUri(zoneId), headers)).use(_.as[Result[DNSRecord]])

  def deleteDNSRecord(zoneId: ZoneId, dnsRecordId: DNSRecordId): F[Result[DNSRecordId]] =
    given Decoder[Id, Cursor[Json], DNSRecordId] = codecDNSRecordIdObjectS[Id, Json]
    client.run(DELETE(dnsRecordsUri(zoneId) / dnsRecordId, headers)).use(_.as[Result[DNSRecordId]])

  def dnsRecordDetails(zoneId: ZoneId, dnsRecordId: DNSRecordId): F[Result[DNSRecord]] =
    client.run(GET(dnsRecordsUri(zoneId) / dnsRecordId, headers)).use(_.as[Result[DNSRecord]])

  def updateDNSRecord(zoneId: ZoneId, dnsRecordId: DNSRecordId)(body: DNSRecordBody): F[Result[DNSRecord]] =
    client.run(PATCH(body, dnsRecordsUri(zoneId) / dnsRecordId, headers)).use(_.as[Result[DNSRecord]])

  def overwriteDNSRecord(zoneId: ZoneId, dnsRecordId: DNSRecordId)(body: DNSRecordBody): F[Result[DNSRecord]] =
    client.run(PUT(body, dnsRecordsUri(zoneId) / dnsRecordId, headers)).use(_.as[Result[DNSRecord]])
end DNSRecordApi
