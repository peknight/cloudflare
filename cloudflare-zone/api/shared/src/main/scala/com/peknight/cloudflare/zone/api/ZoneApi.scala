package com.peknight.cloudflare.zone.api

import com.peknight.cloudflare.Result
import com.peknight.cloudflare.zone.Zone
import com.peknight.cloudflare.zone.query.ListZonesQuery

trait ZoneApi[F[_]]:
  def listZones(query: ListZonesQuery): F[Result[List[Zone]]]
end ZoneApi
