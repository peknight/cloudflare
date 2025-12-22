package com.peknight.cloudflare.zone

import cats.{Monad, Show}
import com.peknight.cloudflare.config.given
import com.peknight.codec.Codec
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.sum.{NullType, ObjectType, StringType}

case class Owner(id: Option[OwnerId], name: Option[String], `type`: String, email: Option[String])
object Owner:
  given codecOwner[F[_]: Monad, S: {ObjectType, NullType, StringType, Show}]: Codec[F, S, Cursor[S], Owner] =
    Codec.derived[F, S, Owner]
end Owner
