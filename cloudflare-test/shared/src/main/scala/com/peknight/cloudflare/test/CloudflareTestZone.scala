package com.peknight.cloudflare.test

import com.peknight.cloudflare.zone.ZoneId

trait CloudflareTestZone:
  def zoneId: ZoneId
end CloudflareTestZone
