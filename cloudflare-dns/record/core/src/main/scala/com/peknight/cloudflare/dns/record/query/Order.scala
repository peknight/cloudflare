package com.peknight.cloudflare.dns.record.query

import cats.Show

enum Order extends com.peknight.cloudflare.query.Order:
  case Type, Name, Content, TTL, Proxied
end Order
object Order:
  given showOrder: Show[Order] = Show.fromToString[Order]
end Order