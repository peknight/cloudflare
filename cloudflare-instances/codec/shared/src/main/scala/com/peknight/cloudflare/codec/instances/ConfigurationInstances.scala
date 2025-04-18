package com.peknight.cloudflare.codec.instances

import com.peknight.codec.config.CodecConfig
import com.peknight.commons.text.cases.SnakeCase
import com.peknight.commons.text.syntax.cases.to

trait ConfigInstances:
  given config: CodecConfig = CodecConfig.default.withTransformMemberName(_.to(SnakeCase))
end ConfigInstances
object ConfigInstances extends ConfigInstances
