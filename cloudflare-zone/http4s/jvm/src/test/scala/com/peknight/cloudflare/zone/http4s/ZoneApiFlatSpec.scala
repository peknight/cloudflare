package com.peknight.cloudflare.zone.http4s

import cats.Show
import cats.data.EitherT
import cats.effect.IO
import cats.effect.testing.scalatest.AsyncIOSpec
import cats.syntax.option.*
import com.peknight.api.syntax.result.asError as resultAsError
import com.peknight.auth.token.Token
import com.peknight.cloudflare.query.Direction.Desc
import com.peknight.cloudflare.query.Match.Any
import com.peknight.cloudflare.query.StringParam
import com.peknight.cloudflare.zone.ZoneStatus.Active
import com.peknight.cloudflare.zone.query.ListZonesQuery
import com.peknight.cloudflare.zone.query.Order.Name
import com.peknight.codec.Decoder
import com.peknight.codec.effect.instances.envReader.given
import com.peknight.codec.reader.Key
import com.peknight.error.syntax.applicativeError.asError
import com.peknight.logging.syntax.eitherT.log
import org.http4s.client.Client
import org.http4s.ember.client.EmberClientBuilder
import org.scalatest.flatspec.AsyncFlatSpec
import org.typelevel.log4cats.Logger
import org.typelevel.log4cats.slf4j.Slf4jLogger

class ZoneApiFlatSpec extends AsyncFlatSpec with AsyncIOSpec:
  "CloudFlare Zone Api List Zones" should "succeed" in {
    val query = ListZonesQuery(
      direction = Desc.some,
      `match` = Any.some,
      order = Name.some,
      name = StringParam(equal = "peknight.com".some).some,
      perPage = 5.some,
      status = Active.some
    )
    EmberClientBuilder.default[IO].build
      .use { client =>
        given Client[IO] = client
        given Decoder[IO, String, Token] = Decoder[IO, String, String].map(Token.Bearer.apply)
        given Show[Token] = Show.fromToString[Token]
        val eitherT =
          for
            logger <- EitherT(Slf4jLogger.fromClass[IO](classOf[ZoneApiFlatSpec]).asError)
            given Logger[IO] = logger
            token <- EitherT(Decoder.load[IO, Token](Key(Vector("CLOUDFLARE", "TOKEN"))))
              .log[Unit]("ZoneApiFlatSpec#loadToken")
            zones <- EitherT(ZoneApi[IO](token).listZones(query).resultAsError)
          yield
            zones
        eitherT.value
      }
      .asserting(either => assert(either.isRight))
  }
end ZoneApiFlatSpec
