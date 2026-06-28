package com.peknight.cloudflare.zone.query

import cats.{Monad, Show}
import com.peknight.cloudflare.config.given
import com.peknight.cloudflare.query.StringParam
import com.peknight.cloudflare.zone.AccountId
import com.peknight.codec.Codec
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.sum.{NullType, ObjectType, StringType}

case class Account(id: Option[AccountId] = None, name: Option[StringParam] = None)
object Account:
  given codecAccount[F[_]: Monad, S: {ObjectType, NullType, StringType, Show}]: Codec[F, S, Cursor[S], Account] =
    Codec.derived[F, S, Account]
end Account
