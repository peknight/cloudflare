package com.peknight.cloudflare.zone.api

import com.peknight.cloudflare.zone.Zone
import com.peknight.cloudflare.{Result, Token}

trait ZoneApi[F[_]]:
  def listZones(token: Token): F[Result[List[Zone]]]
end ZoneApi
