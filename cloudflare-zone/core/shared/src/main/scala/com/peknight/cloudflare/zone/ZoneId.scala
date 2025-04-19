package com.peknight.cloudflare.zone

import cats.Show

case class ZoneId(id: String) extends AnyVal
object ZoneId:
  given showZoneId: Show[ZoneId] = Show.fromToString[ZoneId]
end ZoneId
