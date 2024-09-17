package com.peknight.cloudflare.zone.codec.instances

import cats.Monad
import com.peknight.cloudflare.zone.ZoneMeta
import com.peknight.codec.Codec
import com.peknight.codec.configuration.CodecConfiguration
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.sum.*

trait ZoneMetaInstances:
  given codecZoneMeta[F[_], S](using CodecConfiguration, Monad[F], ObjectType[S], NullType[S], NumberType[S],
                               BooleanType[S], StringType[S]): Codec[F, S, Cursor[S], ZoneMeta] =
    Codec.derived[F, S, ZoneMeta]
end ZoneMetaInstances
object ZoneMetaInstances extends ZoneMetaInstances
