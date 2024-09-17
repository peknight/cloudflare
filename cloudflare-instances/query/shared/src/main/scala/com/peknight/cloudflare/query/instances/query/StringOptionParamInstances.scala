package com.peknight.cloudflare.query.instances.query

import cats.Monad
import com.peknight.cloudflare.codec.instances.query.stringOptionParam.codecStringOptionParam
import com.peknight.cloudflare.query.StringOptionParam
import com.peknight.codec.Codec
import com.peknight.codec.configuration.CodecConfiguration
import com.peknight.codec.cursor.Cursor
import com.peknight.query.Query

trait StringOptionParamInstances:
  given queryCodecStringOptionParam[F[_]](using CodecConfiguration, Monad[F])
  : Codec[F, Query, Cursor[Query], StringOptionParam] =
    codecStringOptionParam[F, Query]
end StringOptionParamInstances
object StringOptionParamInstances extends StringOptionParamInstances
