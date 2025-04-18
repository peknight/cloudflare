package com.peknight.cloudflare.codec.instances.query

import cats.Monad
import com.peknight.cloudflare.query.StringParam
import com.peknight.codec.Codec
import com.peknight.codec.config.CodecConfig
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.sum.{NullType, ObjectType, StringType}

trait StringParamInstances:
  given codecStringParam[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], StringType[S])
  : Codec[F, S, Cursor[S], StringParam] =
    Codec.derived[F, S, StringParam]
end StringParamInstances
object StringParamInstances extends StringParamInstances
