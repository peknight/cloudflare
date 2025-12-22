package com.peknight.cloudflare.query

import cats.{Monad, Show}
import com.peknight.cloudflare.config.given
import com.peknight.codec.Codec
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.sum.{NullType, ObjectType, StringType}

case class StringOptionParam(exact: Option[String], absent: Option[Unit] = None, contains: Option[String] = None,
                             endsWith: Option[String] = None, present: Option[Unit] = None,
                             startsWith: Option[String] = None)
object StringOptionParam:
  given codecStringOptionParam[F[_]: Monad, S: {ObjectType, NullType, StringType, Show}]
  : Codec[F, S, Cursor[S], StringOptionParam] =
    Codec.derived[F, S, StringOptionParam]
  given showStringOptionParam: Show[StringOptionParam] = Show.fromToString[StringOptionParam]
end StringOptionParam
