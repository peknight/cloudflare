package com.peknight.cloudflare.query

import org.http4s.Query

trait QueryEncoder[T]:
  def encode(t: T): Vector[Query.KeyValue]
end QueryEncoder
