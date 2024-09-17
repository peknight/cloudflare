package com.peknight.cloudflare.codec.instances.query

import cats.Monad
import com.peknight.cloudflare.query.StringOptionParam
import com.peknight.codec.Codec
import com.peknight.codec.configuration.CodecConfiguration
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.sum.{NullType, ObjectType, StringType}

trait StringOptionParamInstances:
  given codecStringOptionParam[F[_], S](using CodecConfiguration, Monad[F], ObjectType[S], NullType[S], StringType[S])
  : Codec[F, S, Cursor[S], StringOptionParam] =
    Codec.derived[F, S, StringOptionParam]
end StringOptionParamInstances
object StringOptionParamInstances extends StringOptionParamInstances
