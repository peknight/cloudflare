package com.peknight.cloudflare

case class Message(code: Int, override val message: String) extends com.peknight.error.Error:
  override def errorType: String = s"$code"
end Message
