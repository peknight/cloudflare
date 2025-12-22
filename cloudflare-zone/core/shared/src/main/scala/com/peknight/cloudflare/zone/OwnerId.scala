package com.peknight.cloudflare.zone

import cats.{Applicative, Show}
import com.peknight.codec.Codec
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.sum.StringType

case class OwnerId(id: String) extends AnyVal
object OwnerId:
  given stringCodecOwnerId[F[_]: Applicative]: Codec[F, String, String, OwnerId] =
    Codec.map[F, String, String, OwnerId](_.id)(OwnerId.apply)

  given codecOwnerIdS[F[_]: Applicative, S: {StringType, Show}]: Codec[F, S, Cursor[S], OwnerId] =
    Codec.codecS[F, S, OwnerId]
end OwnerId
