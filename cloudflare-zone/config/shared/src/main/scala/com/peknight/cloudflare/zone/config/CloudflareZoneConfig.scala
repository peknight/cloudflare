package com.peknight.cloudflare.zone.config

import cats.effect.std.Env
import cats.{Monad, MonadError, Show}
import com.peknight.auth.token.Token
import com.peknight.cloudflare.zone.ZoneId
import com.peknight.codec.config.{CodecConfig, given}
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.effect.instances.envReader.given
import com.peknight.codec.reader.Key
import com.peknight.codec.sum.{NullType, ObjectType, StringType}
import com.peknight.codec.{Codec, Decoder}

case class CloudflareZoneConfig(token: Token, zoneId: ZoneId)
object CloudflareZoneConfig:
  given codecCloudflareZoneConfig[F[_], S](using CodecConfig)(using Monad[F], ObjectType[S], NullType[S], StringType[S],
                                                              Show[S]): Codec[F, S, Cursor[S], CloudflareZoneConfig] =
    given Codec[F, String, String, Token] = Codec.map[F, String, String, Token](_.token)(Token.Bearer.apply)
    given Codec[F, S, Cursor[S], Token] = Codec.codecS[F, S, Token]
    Codec.derived[F, S, CloudflareZoneConfig]

  given keyDecodeCloudflareZoneConfig[F[_]](using MonadError[F, Throwable], Env[F]): Decoder[F, Key, CloudflareZoneConfig] =
    given Decoder[F, String, Token] = Decoder[F, String, String].map(Token.Bearer.apply)
    Decoder.derivedByKey[F, CloudflareZoneConfig]
  given Show[CloudflareZoneConfig] = Show.show[CloudflareZoneConfig](config => s"CloudflareZoneConfig(${config.zoneId})")
end CloudflareZoneConfig
