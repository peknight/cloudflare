package com.peknight.cloudflare.zone.circe.instances

import cats.Monad
import com.peknight.cloudflare.zone.Zone
import com.peknight.cloudflare.zone.codec.instances.zone.codecZone
import com.peknight.codec.Codec
import com.peknight.codec.circe.sum.jsonType.given
import com.peknight.codec.config.CodecConfig
import com.peknight.codec.cursor.Cursor
import io.circe.Json

trait ZoneInstances:
  given jsonCodecZone[F[_]](using CodecConfig, Monad[F]): Codec[F, Json, Cursor[Json], Zone] =
    codecZone[F, Json]
end ZoneInstances
object ZoneInstances extends ZoneInstances
