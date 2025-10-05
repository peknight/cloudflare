package com.peknight.cloudflare.zone.http4s

import cats.effect.Concurrent
import com.peknight.auth.http4s.syntax.token.toHeader
import com.peknight.auth.token.Token
import com.peknight.cloudflare.Result
import com.peknight.cloudflare.circe.instances.result.given
import com.peknight.cloudflare.codec.instances.config.given
import com.peknight.cloudflare.http4s.uri.clientV4
import com.peknight.cloudflare.query.instances.queryConfig.given
import com.peknight.cloudflare.zone.circe.instances.zone.given
import com.peknight.cloudflare.zone.query.ListZonesQuery
import com.peknight.cloudflare.zone.query.instances.query.listZonesQuery.given
import com.peknight.cloudflare.zone.{Zone, api}
import com.peknight.codec.circe.sum.jsonType.given
import com.peknight.codec.http4s.circe.instances.entityDecoder.given
import com.peknight.query.http4s.syntax.id.uri.withQuery
import org.http4s.Headers
import org.http4s.Method.GET
import org.http4s.client.Client
import org.http4s.client.dsl.Http4sClientDsl

class ZoneApi[F[_]: Concurrent](token: Token)(using client: Client[F]) extends api.ZoneApi[F]:
  private val dsl: Http4sClientDsl[F] = Http4sClientDsl[F]
  import dsl.*
  private val headers: Headers = Headers(token.toHeader)
  def listZones(query: ListZonesQuery): F[Result[List[Zone]]] =
    client.run(GET((clientV4 / "zones").withQuery[ListZonesQuery](query), headers)).use(_.as[Result[List[Zone]]])
end ZoneApi
