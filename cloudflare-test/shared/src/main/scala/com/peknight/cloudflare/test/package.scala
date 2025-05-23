package com.peknight.cloudflare

import com.peknight.auth.token.Token
import com.peknight.cloudflare.zone.ZoneId

package object test:
  val pekToken: Token.Bearer = Token.Bearer("147lvYY6reQF9xSPqa03S34m_gEOjrwVnfw9JgfZ")
  val pekZoneId: ZoneId = ZoneId("498823170f9a78cf197934b200d2993e")
end test
