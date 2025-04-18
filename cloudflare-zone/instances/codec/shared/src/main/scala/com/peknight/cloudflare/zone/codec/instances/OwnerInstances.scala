package com.peknight.cloudflare.zone.codec.instances

import cats.{Monad, Show}
import com.peknight.cloudflare.zone.Owner
import com.peknight.cloudflare.zone.codec.instances.ownerId.given
import com.peknight.codec.Codec
import com.peknight.codec.config.CodecConfig
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.sum.{NullType, ObjectType, StringType}

trait OwnerInstances:
  given codecOwner[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], StringType[S], Show[S])
  : Codec[F, S, Cursor[S], Owner] =
    Codec.derived[F, S, Owner]
end OwnerInstances
object OwnerInstances extends OwnerInstances
