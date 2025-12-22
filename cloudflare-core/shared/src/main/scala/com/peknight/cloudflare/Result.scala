package com.peknight.cloudflare

import cats.data.Ior
import cats.{Monad, Show}
import com.peknight.cloudflare.Result
import com.peknight.codec.config.CodecConfig
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.sum.*
import com.peknight.codec.{Codec, Decoder, Encoder}
import com.peknight.commons.text.cases.SnakeCase
import com.peknight.commons.text.syntax.cases.to

case class Result[A](
                      result: Option[A],
                      override val success: Boolean,
                      resultInfo: Option[ResultInfo],
                      errors: List[Error],
                      msgs: List[Message]
                    ) extends com.peknight.api.Result[ResultInfo, A]:
  def ior: com.peknight.error.Error Ior A =
    (result, errors, msgs) match
      case (Some(res), Nil, Nil) => Ior.right(res)
      case (Some(res), errs, msgs) => Ior.both(com.peknight.error.Error(errs ::: msgs), res)
      case (None, errs, msgs) => Ior.left(com.peknight.error.Error(errs ::: msgs))
  override def data: Option[A] = result
  override def pagination: Option[ResultInfo] = resultInfo
end Result
object Result:
  private val memberNameMap: Map[String, String] = Map("msgs" -> "messages")
  given codecResult[F[_], S, A](using Monad[F], ObjectType[S], NullType[S], ArrayType[S], NumberType[S], BooleanType[S],
                                StringType[S], Encoder[F, S, A], Decoder[F, Cursor[S], A], Show[S])
  : Codec[F, S, Cursor[S], Result[A]] =
    given CodecConfig = CodecConfig.default.withTransformMemberName(memberName =>
      memberNameMap.getOrElse(memberName, memberName.to(SnakeCase))
    )
    Codec.derived[F, S, Result[A]]
end Result