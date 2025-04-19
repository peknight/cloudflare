package com.peknight.cloudflare.dns.record

import cats.Show

enum LongitudeDirection:
  case E, W
end LongitudeDirection
object LongitudeDirection:
  given showLongitudeDirection: Show[LongitudeDirection] = Show.fromToString[LongitudeDirection]
end LongitudeDirection
