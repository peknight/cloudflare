package com.peknight.cloudflare

import cats.{Monad, Show}
import com.peknight.cloudflare.config.given
import com.peknight.codec.Codec
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.sum.*

case class Error(code: Int, override val message: String, errorChain: Option[List[Error]]) extends com.peknight.error.Error:
  override def errorType: String = s"$code"
  override def cause: Option[com.peknight.error.Error] = errorChain.map(com.peknight.error.Error.apply)
end Error
object Error:
  given codecError[F[_]: Monad, S: {ObjectType, NullType, ArrayType, NumberType, StringType, Show}]
  : Codec[F, S, Cursor[S], Error] =
    Codec.derived[F, S, Error]
end Error
