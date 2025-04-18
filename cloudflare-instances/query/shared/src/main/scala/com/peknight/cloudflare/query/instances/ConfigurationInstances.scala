package com.peknight.cloudflare.query.instances

import com.peknight.query.config.Config

trait ConfigInstances:
  given Config = Config(defaultKeys = List("equal", "exact"), flagKeys = List("absent", "present"))
end ConfigInstances
object ConfigInstances extends ConfigInstances
