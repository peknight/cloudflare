package com.peknight.cloudflare

case class Result[T](result: T, success: Boolean, resultInfo: Option[ResultInfo], errors: List[Error], messages: List[Message])
