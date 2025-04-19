package com.peknight.cloudflare.query

import cats.Show

enum Match:
  case All, Any
end Match
object Match:
  given showMatch: Show[Match] = Show.fromToString[Match]
end Match