package com.peknight.cloudflare.codec.instances

import cats.Monad
import com.peknight.cloudflare.Error
import com.peknight.codec.Codec
import com.peknight.codec.configuration.CodecConfiguration
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.sum.{NullType, NumberType, ObjectType, StringType}

trait ErrorInstances:
  given codecError[F[_], S](using CodecConfiguration, Monad[F], ObjectType[S], NullType[S], NumberType[S],
                            StringType[S]): Codec[F, S, Cursor[S], Error] =
    Codec.derived[F, S, Error]
end ErrorInstances
object ErrorInstances extends ErrorInstances
