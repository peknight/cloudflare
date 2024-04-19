package com.peknight.cloudflare.dns.record.http4s

import cats.effect.Concurrent
import com.peknight.cloudflare.circe.instances.result.given
import com.peknight.cloudflare.codec.instances.configuration.given
import com.peknight.cloudflare.dns.record.circe.instances.dnsRecord.given
import com.peknight.cloudflare.dns.record.{DNSRecord, api}
import com.peknight.cloudflare.http4s.headers.toHeader
import com.peknight.cloudflare.http4s.uri.clientV4
import com.peknight.cloudflare.zone.ZoneId
import com.peknight.cloudflare.zone.codec.instances.zoneId.given
import com.peknight.cloudflare.{Result, Token}
import com.peknight.codec.http4s.circe.instances.entityDecoder.given
import com.peknight.codec.http4s.instances.segmentEncoder.given
import org.http4s.Headers
import org.http4s.Method.GET
import org.http4s.client.Client
import org.http4s.client.dsl.Http4sClientDsl

class DNSRecordApi[F[_]: Concurrent](client: Client[F])(dsl: Http4sClientDsl[F]) extends api.DNSRecordApi[F]:
  import dsl.*
  def listDNSRecords(zoneIdentifier: ZoneId)(token: Token): F[Result[List[DNSRecord]]] =
    client.run(GET(clientV4 / "zones" / zoneIdentifier / "dns_records", Headers(token.toHeader)))
      .use(_.as[Result[List[DNSRecord]]])
end DNSRecordApi
