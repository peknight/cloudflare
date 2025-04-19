package com.peknight.cloudflare.dns.record

import cats.Show

enum LatitudeDirection:
  case N, S
end LatitudeDirection
object LatitudeDirection:
  given showLatitudeDirection: Show[LatitudeDirection] = Show.fromToString[LatitudeDirection]
end LatitudeDirection
