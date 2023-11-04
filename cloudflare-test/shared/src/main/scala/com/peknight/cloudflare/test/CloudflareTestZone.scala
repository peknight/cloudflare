package com.peknight.cloudflare.test

import com.peknight.cloudflare.zone.ZoneId

trait CloudflareTestZone:
  def zoneIdentifier: ZoneId
end CloudflareTestZone
