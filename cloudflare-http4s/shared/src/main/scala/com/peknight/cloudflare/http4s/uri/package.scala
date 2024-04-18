package com.peknight.cloudflare.http4s

import org.http4s.syntax.literals.uri

package object uri:
  val api = uri"https://api.cloudflare.com"
  val client = api / "client"
  val clientV4 = client / "v4"
end uri
