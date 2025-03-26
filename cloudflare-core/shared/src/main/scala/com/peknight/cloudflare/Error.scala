package com.peknight.cloudflare

case class Error(code: Int, override val message: String, errorChain: Option[List[Error]]) extends com.peknight.error.Error:
  override def errorType: String = s"$code"
  override def cause: Option[com.peknight.error.Error] = errorChain.map(com.peknight.error.Error.apply)
end Error
