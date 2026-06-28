package com.peknight.cloudflare.zone

import cats.{Applicative, Show}
import com.peknight.codec.Codec
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.sum.StringType

case class AccountId(id: String) extends AnyVal
object AccountId:
  given stringCodecAccountId[F[_]: Applicative]: Codec[F, String, String, AccountId] =
    Codec.map[F, String, String, AccountId](_.id)(AccountId.apply)

  given codecAccountIdS[F[_]: Applicative, S: {StringType, Show}]: Codec[F, S, Cursor[S], AccountId] =
    Codec.codecS[F, S, AccountId]
end AccountId
