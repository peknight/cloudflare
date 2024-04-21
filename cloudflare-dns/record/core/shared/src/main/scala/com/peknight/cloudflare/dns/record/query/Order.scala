package com.peknight.cloudflare.dns.record.query

enum Order extends com.peknight.cloudflare.query.Order:
  case Type, Name, Content, TTL, Proxied
end Order