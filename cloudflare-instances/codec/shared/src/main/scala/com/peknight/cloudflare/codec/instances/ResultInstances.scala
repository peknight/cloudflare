package com.peknight.cloudflare.codec.instances

import cats.Monad
import com.peknight.cloudflare.Result
import com.peknight.cloudflare.codec.instances.error.given
import com.peknight.cloudflare.codec.instances.message.given
import com.peknight.cloudflare.codec.instances.resultInfo.given
import com.peknight.codec.{Codec, Decoder, Encoder}
import com.peknight.codec.configuration.CodecConfiguration
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.sum.{NullType, NumberType, ObjectType, StringType}

trait ResultInstances:
  given codecResult[F[_], S, A](using CodecConfiguration, Monad[F], ObjectType[S], NullType[S], NumberType[S],
                                StringType[S], Encoder[F, S, A], Decoder[F, Cursor[S], A])
  : Codec[F, S, Cursor[S], Result[A]] =
    Codec.derived[F, S, Result[A]]
end ResultInstances
object ResultInstances extends ResultInstances
