package com.peknight.cloudflare.dns.record.http4s

import cats.effect.Concurrent
import com.peknight.cloudflare.circe.instances.configuration.given
import com.peknight.cloudflare.http4s.headers.toHeader
import com.peknight.cloudflare.http4s.uri.v4
import com.peknight.cloudflare.{Result, Token}
import com.peknight.generic.circe.decoder.given
import io.circe.Decoder
import org.http4s.Method.GET
import org.http4s.circe.jsonOf
import org.http4s.client.Client
import org.http4s.client.dsl.Http4sClientDsl
import org.http4s.{EntityDecoder, Headers}

class DNSRecordApi[F[_]: Concurrent](client: Client[F])(dsl: Http4sClientDsl[F]):
  import dsl.*
  given [A: Decoder]: EntityDecoder[F, A] = jsonOf[F, A]
end DNSRecordApi
