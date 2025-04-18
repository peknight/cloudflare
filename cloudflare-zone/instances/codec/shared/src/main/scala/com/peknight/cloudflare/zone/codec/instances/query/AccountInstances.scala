package com.peknight.cloudflare.zone.codec.instances.query

import cats.{Monad, Show}
import com.peknight.cloudflare.codec.instances.query.stringParam.given
import com.peknight.cloudflare.zone.codec.instances.accountId.given
import com.peknight.cloudflare.zone.query.Account
import com.peknight.codec.Codec
import com.peknight.codec.config.CodecConfig
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.sum.{NullType, ObjectType, StringType}

trait AccountInstances:
  given codecAccount[F[_], S](using CodecConfig, Monad[F], ObjectType[S], NullType[S], StringType[S], Show[S])
  : Codec[F, S, Cursor[S], Account] =
    Codec.derived[F, S, Account]
end AccountInstances
object AccountInstances extends AccountInstances
