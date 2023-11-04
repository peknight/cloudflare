package com.peknight.cloudflare.zone.http4s

import cats.effect.Concurrent
import com.peknight.cloudflare.circe.instances.result.given
import com.peknight.cloudflare.http4s.headers.toHeader
import com.peknight.cloudflare.http4s.uri.v4
import com.peknight.cloudflare.zone.{Zone, api}
import com.peknight.cloudflare.zone.circe.instances.zone.given
import com.peknight.cloudflare.{Result, Token}
import io.circe.Decoder
import org.http4s.Method.GET
import org.http4s.circe.jsonOf
import org.http4s.client.Client
import org.http4s.client.dsl.Http4sClientDsl
import org.http4s.{EntityDecoder, Headers}

class ZoneApi[F[_]: Concurrent](client: Client[F])(dsl: Http4sClientDsl[F]) extends api.ZoneApi[F]:
  import dsl.*
  given [A: Decoder]: EntityDecoder[F, A] = jsonOf[F, A]
  def listZones(token: Token): F[Result[List[Zone]]] =
    client.run(GET(v4 / "zones", Headers(token.toHeader))).use(_.as[Result[List[Zone]]])
end ZoneApi
