package com.peknight.cloudflare.query.instances

import com.peknight.query.config.QueryConfig

trait QueryConfigInstances:
  given QueryConfig = QueryConfig(defaultKeys = List("equal", "exact"), flagKeys = List("absent", "present"))
end QueryConfigInstances
object QueryConfigInstances extends QueryConfigInstances
