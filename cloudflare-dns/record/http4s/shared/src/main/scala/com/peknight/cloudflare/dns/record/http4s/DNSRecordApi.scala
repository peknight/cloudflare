package com.peknight.cloudflare.dns.record.http4s

import cats.effect.Concurrent
import com.peknight.cloudflare.circe.instances.result.given
import com.peknight.cloudflare.dns.record.circe.instances.dnsRecord.given
import com.peknight.cloudflare.dns.record.{DNSRecord, api}
import com.peknight.cloudflare.http4s.headers.toHeader
import com.peknight.cloudflare.http4s.uri.v4
import com.peknight.cloudflare.zone.ZoneId
import com.peknight.cloudflare.zone.http4s.instances.zoneId.given
import com.peknight.cloudflare.{Result, Token}
import io.circe.Decoder
import org.http4s.Method.GET
import org.http4s.circe.jsonOf
import org.http4s.client.Client
import org.http4s.client.dsl.Http4sClientDsl
import org.http4s.{EntityDecoder, Headers}

class DNSRecordApi[F[_]: Concurrent](client: Client[F])(dsl: Http4sClientDsl[F]) extends api.DNSRecordApi[F]:
  import dsl.*
  given [A: Decoder]: EntityDecoder[F, A] = jsonOf[F, A]
  def listDNSRecords(zoneIdentifier: ZoneId)(token: Token): F[Result[List[DNSRecord]]] =
    client.run(GET(v4 / "zones" / zoneIdentifier / "dns_records", Headers(token.toHeader)))
      .use(_.as[Result[List[DNSRecord]]])
end DNSRecordApi
