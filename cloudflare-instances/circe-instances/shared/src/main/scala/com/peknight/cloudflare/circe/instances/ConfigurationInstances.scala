package com.peknight.cloudflare.circe.instances

import io.circe.derivation.Configuration

trait ConfigurationInstances:
  given Configuration = Configuration.default.withSnakeCaseMemberNames
end ConfigurationInstances
object ConfigurationInstances extends ConfigurationInstances
