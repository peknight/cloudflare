package com.peknight.cloudflare.query

import cats.Show

enum Direction:
  case Desc, Asc
end Direction
object Direction:
  given showDirection: Show[Direction] = Show.fromToString[Direction]
end Direction