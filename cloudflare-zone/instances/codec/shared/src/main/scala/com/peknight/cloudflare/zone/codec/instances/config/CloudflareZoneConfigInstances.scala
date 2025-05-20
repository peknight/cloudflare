package com.peknight.cloudflare.zone.codec.instances.config

import cats.MonadError
import cats.effect.std.Env
import com.peknight.auth.token.Token
import com.peknight.cloudflare.zone.codec.instances.zoneId.given
import com.peknight.cloudflare.zone.config.CloudflareZoneConfig
import com.peknight.codec.Decoder
import com.peknight.codec.config.given
import com.peknight.codec.effect.instances.envReader.given
import com.peknight.codec.reader.Key

trait CloudflareZoneConfigInstances:
  given keyDecodeCloudflareZoneConfig[F[_]](using MonadError[F, Throwable], Env[F]): Decoder[F, Key, CloudflareZoneConfig] =
    given Decoder[F, String, Token] = Decoder[F, String, String].map(Token.Bearer.apply)
    Decoder.derivedByKey[F, CloudflareZoneConfig]
end CloudflareZoneConfigInstances
object CloudflareZoneConfigInstances extends CloudflareZoneConfigInstances
