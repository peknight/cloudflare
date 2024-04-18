package com.peknight.cloudflare.codec.instances

import com.peknight.codec.configuration.CodecConfiguration
import com.peknight.commons.string.cases.SnakeCase
import com.peknight.commons.string.syntax.cases.to

trait ConfigurationInstances:
  given configuration: CodecConfiguration = CodecConfiguration(transformMemberNames = _.to(SnakeCase))
end ConfigurationInstances
object ConfigurationInstances extends ConfigurationInstances
