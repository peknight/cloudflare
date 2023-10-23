package com.peknight.cloudflare

sealed trait Token
object Token:
  case class BearerAuth(token: String) extends Token
  case class ApiKey(key: String) extends Token
  case class ApiEmail(email: String) extends Token
  case class UserServiceKey(key: String) extends Token
end Token
