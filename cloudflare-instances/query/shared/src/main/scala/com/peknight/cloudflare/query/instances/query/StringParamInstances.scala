package com.peknight.cloudflare.query.instances.query

import cats.Monad
import com.peknight.cloudflare.query.StringParam
import com.peknight.codec.Codec
import com.peknight.codec.configuration.CodecConfiguration
import com.peknight.codec.cursor.Cursor
import com.peknight.query.Query

trait StringParamInstances:
  given codecStringParam[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Query, Cursor[Query], StringParam] =
    Codec.derived[F, Query, StringParam]
end StringParamInstances
object StringParamInstances extends StringParamInstances
