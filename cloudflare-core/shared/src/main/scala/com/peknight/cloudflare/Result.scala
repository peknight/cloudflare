package com.peknight.cloudflare

import cats.data.Ior
import com.peknight.api.pagination.Pagination

case class Result[A](
                      result: Option[A],
                      override val success: Boolean,
                      resultInfo: Option[ResultInfo],
                      errors: List[Error],
                      msgs: List[Message]
                    ) extends com.peknight.api.Result[A]:
  def ior: com.peknight.error.Error Ior A =
    (result, errors, msgs) match
      case (Some(res), Nil, Nil) => Ior.right(res)
      case (Some(res), errs, msgs) => Ior.both(com.peknight.error.Error(errs ::: msgs), res)
      case (None, errs, msgs) => Ior.left(com.peknight.error.Error(errs ::: msgs))
  override def data: Option[A] = result
  override def pagination: Option[Pagination] = resultInfo
end Result
