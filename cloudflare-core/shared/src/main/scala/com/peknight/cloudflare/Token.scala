package com.peknight.cloudflare

sealed trait Token
object Token:
  case class BearerAuth(token: String) extends Token
end Token
