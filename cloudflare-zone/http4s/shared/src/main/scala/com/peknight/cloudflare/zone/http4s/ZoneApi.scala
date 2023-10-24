package com.peknight.cloudflare.zone.http4s

import cats.effect.Concurrent
import com.peknight.cloudflare.circe.instances.decoder.given
import com.peknight.cloudflare.http4s.headers.toHeader
import com.peknight.cloudflare.http4s.uri.v4
import com.peknight.cloudflare.{Result, Token}
import io.circe.{Decoder, Json}
import org.http4s.{EntityDecoder, Headers}
import org.http4s.Method.GET
import org.http4s.circe.{jsonOf, jsonDecoder}
import org.http4s.client.Client
import org.http4s.client.dsl.Http4sClientDsl

class ZoneApi[F[_]: Concurrent](client: Client[F])(dsl: Http4sClientDsl[F]):
  import dsl.*
  // given [F[_] : Concurrent, A: Decoder]: EntityDecoder[F, Result[A]] = jsonOf[F, Result[A]]
  // def listZones(token: Token): F[Result[Json]] = client.run(GET(v4 / "zones", Headers(token.toHeader))).use(_.as[Result[Json]])
end ZoneApi
