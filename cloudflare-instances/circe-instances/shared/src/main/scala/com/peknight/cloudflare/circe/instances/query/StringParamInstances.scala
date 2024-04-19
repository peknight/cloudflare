package com.peknight.cloudflare.circe.instances.query

import cats.Monad
import com.peknight.cloudflare.query.StringParam
import com.peknight.codec.Codec
import com.peknight.codec.circe.sum.JsonTypeInstances
import com.peknight.codec.configuration.CodecConfiguration
import com.peknight.codec.cursor.Cursor
import io.circe.Json

trait StringParamInstances extends JsonTypeInstances:
  given codecStringParam[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Json, Cursor[Json], StringParam] =
    Codec.derived[F, Json, StringParam]
end StringParamInstances
object StringParamInstances extends StringParamInstances
