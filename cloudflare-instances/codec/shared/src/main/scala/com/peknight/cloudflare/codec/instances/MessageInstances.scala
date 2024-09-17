package com.peknight.cloudflare.codec.instances

import cats.Monad
import com.peknight.cloudflare.Message
import com.peknight.codec.Codec
import com.peknight.codec.configuration.CodecConfiguration
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.sum.{NullType, NumberType, ObjectType, StringType}

trait MessageInstances:
  given codecMessage[F[_], S](using CodecConfiguration, Monad[F], ObjectType[S], NullType[S], NumberType[S],
                              StringType[S]): Codec[F, S, Cursor[S], Message] =
    Codec.derived[F, S, Message]
end MessageInstances
object MessageInstances extends MessageInstances
