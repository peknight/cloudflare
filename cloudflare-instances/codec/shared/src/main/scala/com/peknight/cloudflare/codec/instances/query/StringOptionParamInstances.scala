package com.peknight.cloudflare.codec.instances.query

import cats.Monad
import com.peknight.cloudflare.query.StringOptionParam
import com.peknight.codec.Codec
import com.peknight.codec.config.CodecConfig
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.sum.{NullType, ObjectType, StringType}

trait StringOptionParamInstances:
  given codecStringOptionParam[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], StringType[S])
  : Codec[F, S, Cursor[S], StringOptionParam] =
    Codec.derived[F, S, StringOptionParam]
end StringOptionParamInstances
object StringOptionParamInstances extends StringOptionParamInstances
