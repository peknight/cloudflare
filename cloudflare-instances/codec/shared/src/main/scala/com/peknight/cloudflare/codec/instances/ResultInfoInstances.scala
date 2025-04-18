package com.peknight.cloudflare.codec.instances

import cats.Monad
import com.peknight.cloudflare.ResultInfo
import com.peknight.codec.config.CodecConfig
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.sum.{NullType, NumberType, ObjectType, StringType}
import com.peknight.codec.{Codec, Decoder, Encoder}
import com.peknight.generic.Generic

trait ResultInfoInstances:
  given codecResultInfo[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], NumberType[S],
                                 StringType[S]): Codec[F, S, Cursor[S], ResultInfo] =
    Codec.derived[F, S, ResultInfo]
end ResultInfoInstances
object ResultInfoInstances extends ResultInfoInstances
