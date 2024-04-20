package com.peknight.cloudflare.query.instances

import com.peknight.query.configuration.Configuration

trait ConfigurationInstances:
  given Configuration = Configuration(defaultKey = Some("equal"))
end ConfigurationInstances
object ConfigurationInstances extends ConfigurationInstances
