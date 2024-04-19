package com.peknight.cloudflare.zone.query

import com.peknight.cloudflare.query.{Direction, Match, QueryParam, StringParam}
import com.peknight.cloudflare.zone.ZoneStatus

case class ListZonesQuery(account: Option[Account] = None, direction: Option[Direction] = None,
                          `match`: Option[Match] = None, name: Option[StringParam] = None, order: Option[Order] = None,
                          page: Option[Int] = None, perPage: Option[Int] = None, status: Option[ZoneStatus] = None)
  extends QueryParam
