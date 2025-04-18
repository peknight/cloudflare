package com.peknight.cloudflare.circe.instances

import cats.{Id, Monad}
import com.peknight.cloudflare.Result
import com.peknight.cloudflare.codec.instances.result.codecResult
import com.peknight.codec.circe.iso.codec
import com.peknight.codec.circe.sum.jsonType.given
import com.peknight.codec.config.CodecConfig
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.{Codec, Decoder, Encoder}
import io.circe.Json

trait ResultInstances:
  given jsonCodecResult[F[_], A](using CodecConfig, Monad[F], Encoder[F, Json, A], Decoder[F, Cursor[Json], A])
  : Codec[F, Json, Cursor[Json], Result[A]] =
    codecResult[F, Json, A]

  given circeCodecResult[A](using CodecConfig, Encoder[Id, Json, A], Decoder[Id, Cursor[Json], A])
  : io.circe.Codec[Result[A]] =
    codec[Result[A]]
end ResultInstances
object ResultInstances extends ResultInstances
