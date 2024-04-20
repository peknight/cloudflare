package com.peknight.cloudflare.query.instances

import com.peknight.query.configuration.Configuration

trait ConfigurationInstances:
  given Configuration = Configuration(defaultKeys = List("equal", "exact"))
end ConfigurationInstances
object ConfigurationInstances extends ConfigurationInstances
