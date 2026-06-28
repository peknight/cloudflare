package com.peknight.cloudflare

import com.peknight.codec.config.CodecConfig
import com.peknight.commons.text.cases.SnakeCase
import com.peknight.commons.text.syntax.cases.to
import com.peknight.query.config.QueryConfig

package object config:
  given codecConfig: CodecConfig = CodecConfig.default.withTransformMemberName(_.to(SnakeCase))
  given queryConfig: QueryConfig = QueryConfig(defaultKeys = List("equal", "exact"), flagKeys = List("absent", "present"))
end config
