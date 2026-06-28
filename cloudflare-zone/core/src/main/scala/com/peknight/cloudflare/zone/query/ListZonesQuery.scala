package com.peknight.cloudflare.zone.query

import cats.{Monad, Show}
import com.peknight.cloudflare.config.given
import com.peknight.cloudflare.query.{Direction, Match, QueryParam, StringParam}
import com.peknight.cloudflare.zone.ZoneStatus
import com.peknight.cloudflare.zone.query.ListZonesQuery
import com.peknight.codec.Codec
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.sum.{NullType, NumberType, ObjectType, StringType}

case class ListZonesQuery(account: Option[Account] = None, direction: Option[Direction] = None,
                          `match`: Option[Match] = None, name: Option[StringParam] = None, order: Option[Order] = None,
                          page: Option[Int] = None, perPage: Option[Int] = None, status: Option[ZoneStatus] = None)
  extends QueryParam
object ListZonesQuery:
  given codecListZonesQuery[F[_]: Monad, S: {ObjectType, NullType, NumberType, StringType, Show}]
  : Codec[F, S, Cursor[S], ListZonesQuery] =
    Codec.derived[F, S, ListZonesQuery]
end ListZonesQuery

