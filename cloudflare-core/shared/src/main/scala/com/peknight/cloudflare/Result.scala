package com.peknight.cloudflare

import cats.data.Ior
import com.peknight.error

case class Result[A](
                      result: Option[A],
                      override val success: Boolean,
                      resultInfo: Option[ResultInfo],
                      errors: List[Error],
                      msgs: List[Message]
                    ) extends com.peknight.api.Result[A]:
  def ior: com.peknight.error.Error Ior A =
    (result, errors) match
      case (Some(res), Nil) => Ior.right(res)
      case (Some(res), errs) => Ior.both(com.peknight.error.Error(errs), res)
      case (None, errs) => Ior.left(com.peknight.error.Error(errs))
  override def data: Option[A] = result
  override def messages: List[String] = msgs.map(_.message)
end Result
