package com.peknight.cloudflare.query.instances.query

import cats.Monad
import com.peknight.cloudflare.query.StringOptionParam
import com.peknight.codec.Codec
import com.peknight.codec.configuration.CodecConfiguration
import com.peknight.codec.cursor.Cursor
import com.peknight.query.Query

trait StringOptionParamInstances:
  given codecStringOptionParam[F[_]](using CodecConfiguration, Monad[F])
  : Codec[F, Query, Cursor[Query], StringOptionParam] =
    Codec.derived[F, Query, StringOptionParam]

end StringOptionParamInstances
object StringOptionParamInstances extends StringOptionParamInstances
