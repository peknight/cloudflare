package com.peknight.cloudflare.query

import org.http4s.Uri

object QueryApp:
  val uri = Uri.unsafeFromString("www.peknight.com")
end QueryApp
