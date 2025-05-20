package com.peknight.cloudflare.zone.config

import cats.Show
import com.peknight.auth.token.Token
import com.peknight.cloudflare.zone.ZoneId

case class CloudflareZoneConfig(token: Token, zoneId: ZoneId)
object CloudflareZoneConfig:
  given Show[CloudflareZoneConfig] = Show.show[CloudflareZoneConfig](config => s"CloudflareZoneConfig(${config.zoneId})")
end CloudflareZoneConfig
