package com.peknight.cloudflare.zone.http4s

import cats.Id
import cats.effect.Concurrent
import com.peknight.cloudflare.circe.instances.result.given
import com.peknight.cloudflare.codec.instances.configuration.given
import com.peknight.cloudflare.codec.instances.query.all.given
import com.peknight.cloudflare.http4s.headers.toHeader
import com.peknight.cloudflare.http4s.uri.clientV4
import com.peknight.cloudflare.query.instances.configuration.given
import com.peknight.cloudflare.zone.circe.instances.zone.given
import com.peknight.cloudflare.zone.query.ListZonesQuery
import com.peknight.cloudflare.zone.{Zone, api}
import com.peknight.cloudflare.{Result, Token}
import com.peknight.codec.http4s.circe.instances.entityDecoder.given
import com.peknight.query.Query
import com.peknight.query.codec.id.Encoder
import com.peknight.query.http4s.syntax.id.uri.withQuery
import org.http4s.Headers
import org.http4s.Method.GET
import org.http4s.client.Client
import org.http4s.client.dsl.Http4sClientDsl

class ZoneApi[F[_]: Concurrent](client: Client[F])(dsl: Http4sClientDsl[F]) extends api.ZoneApi[F]:
  import dsl.*
  def listZones(query: ListZonesQuery)(token: Token): F[Result[List[Zone]]] =
    given Encoder[ListZonesQuery] = com.peknight.codec.Encoder.derived[Id, Query, ListZonesQuery]
    client.run(GET((clientV4 / "zones").withQuery[ListZonesQuery](query), Headers(token.toHeader)))
      .use(_.as[Result[List[Zone]]])
end ZoneApi
