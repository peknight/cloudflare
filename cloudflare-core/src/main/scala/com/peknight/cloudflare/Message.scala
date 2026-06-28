package com.peknight.cloudflare

import cats.{Monad, Show}
import com.peknight.cloudflare.config.given
import com.peknight.codec.Codec
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.sum.{NullType, NumberType, ObjectType, StringType}

case class Message(code: Int, override val message: String) extends com.peknight.error.Error:
  override def errorType: String = s"$code"
end Message
object Message:
  given codecMessage[F[_]: Monad, S: {ObjectType, NullType, NumberType, StringType, Show}]
  : Codec[F, S, Cursor[S], Message] =
    Codec.derived[F, S, Message]
end Message
