package com.peknight.cloudflare.codec.instances

import cats.{Monad, Show}
import com.peknight.cloudflare.Error
import com.peknight.codec.Codec
import com.peknight.codec.config.CodecConfig
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.sum.*

trait ErrorInstances:
  given codecError[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], ArrayType[S], NumberType[S],
                            StringType[S], Show[S]): Codec[F, S, Cursor[S], Error] =
    Codec.derived[F, S, Error]
end ErrorInstances
object ErrorInstances extends ErrorInstances
