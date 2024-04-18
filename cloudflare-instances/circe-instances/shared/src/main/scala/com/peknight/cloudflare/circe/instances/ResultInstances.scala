package com.peknight.cloudflare.circe.instances

import cats.Monad
import com.peknight.cloudflare.{Error, Message, Result, ResultInfo}
import com.peknight.codec.circe.sum.JsonTypeInstances
import com.peknight.codec.configuration.CodecConfiguration
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.{Codec, Decoder, Encoder}
import io.circe.Json

trait ResultInstances extends JsonTypeInstances:
  given codecResultInfo[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], ResultInfo] =
    Codec.derived[F, Json, ResultInfo]
  given codecError[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], Error] =
    Codec.derived[F, Json, Error]
  given codecMessage[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], Message] =
    Codec.derived[F, Json, Message]
  given codecResult[F[_], T](using CodecConfiguration, Monad[F], Encoder[F, Json, T], Decoder[F, Cursor[Json], T])
  : Codec[F, Json, Cursor[Json], Result[T]] =
    Codec.derived[F, Json, Result[T]]
end ResultInstances
object ResultInstances extends ResultInstances
