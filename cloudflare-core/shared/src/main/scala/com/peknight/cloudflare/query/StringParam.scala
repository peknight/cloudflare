package com.peknight.cloudflare.query

import cats.{Monad, Show}
import com.peknight.cloudflare.config.given
import com.peknight.codec.Codec
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.sum.{NullType, ObjectType, StringType}

case class StringParam(equal: Option[String] = None, notEqual: Option[String] = None, startsWith: Option[String] = None,
                       endsWith: Option[String] = None, contains: Option[String] = None,
                       startsWithCaseSensitive: Option[String] = None, endsWithCaseSensitive: Option[String] = None,
                       containsCaseSensitive: Option[String] = None)
object StringParam:
  given codecStringParam[F[_]: Monad, S: {ObjectType, NullType, StringType, Show}]: Codec[F, S, Cursor[S], StringParam] =
    Codec.derived[F, S, StringParam]
end StringParam
