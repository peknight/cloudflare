package com.peknight.cloudflare.zone.config

import cats.effect.std.Env
import cats.{MonadError, Show}
import com.peknight.auth.token.Token
import com.peknight.cloudflare.zone.ZoneId
import com.peknight.codec.Decoder
import com.peknight.codec.config.given
import com.peknight.codec.effect.instances.envReader.given
import com.peknight.codec.reader.Key

case class CloudflareZoneConfig(token: Token, zoneId: ZoneId)
object CloudflareZoneConfig:
  given keyDecodeCloudflareZoneConfig[F[_]](using MonadError[F, Throwable], Env[F]): Decoder[F, Key, CloudflareZoneConfig] =
    given Decoder[F, String, Token] = Decoder[F, String, String].map(Token.Bearer.apply)
    Decoder.derivedByKey[F, CloudflareZoneConfig]
  given Show[CloudflareZoneConfig] = Show.show[CloudflareZoneConfig](config => s"CloudflareZoneConfig(${config.zoneId})")
end CloudflareZoneConfig
