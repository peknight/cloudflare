package com.peknight.cloudflare.zone.query

enum Order(val value: String) extends com.peknight.cloudflare.query.Order:
  case Name extends Order("name")
  case Status extends Order("status")
  case AccountId extends Order("account.id")
  case AccountName extends Order("account.name")
end Order