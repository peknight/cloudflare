package com.peknight.cloudflare

import cats.{Monad, Show}
import com.peknight.api.pagination.Pagination
import com.peknight.cloudflare.config.given
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.sum.*
import com.peknight.codec.{Codec, Decoder, Encoder}

case class ResultInfo(
                       // Total number of results for the requested service
                       count: Int,
                       // Current page within paginated list of results
                       page: Int,
                       // Number of results per page of results
                       perPage: Int,
                       // Total results available without any search parameters
                       totalCount: Int,
                       totalPages: Option[Int]
                     ) extends Pagination
object ResultInfo:
  given codecResultInfo[F[_]: Monad, S: {ObjectType, NullType, NumberType, StringType, Show}]
  : Codec[F, S, Cursor[S], ResultInfo] =
    Codec.derived[F, S, ResultInfo]
end ResultInfo