package com.peknight.cloudflare.zone.codec.instances

import cats.Monad
import com.peknight.cloudflare.zone.Owner
import com.peknight.cloudflare.zone.codec.instances.ownerId.given
import com.peknight.codec.Codec
import com.peknight.codec.configuration.CodecConfiguration
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.sum.{NullType, ObjectType, StringType}

trait OwnerInstances:
  given codecOwner[F[_], S](using CodecConfiguration, Monad[F], ObjectType[S], NullType[S], StringType[S])
  : Codec[F, S, Cursor[S], Owner] =
    Codec.derived[F, S, Owner]
end OwnerInstances
object OwnerInstances extends OwnerInstances
