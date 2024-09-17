package com.peknight.cloudflare.zone.codec.instances.query

import cats.Monad
import com.peknight.cloudflare.codec.instances.query.`match`.given
import com.peknight.cloudflare.codec.instances.query.direction.given
import com.peknight.cloudflare.codec.instances.query.order.given
import com.peknight.cloudflare.codec.instances.query.stringParam.given
import com.peknight.cloudflare.zone.codec.instances.query.account.given
import com.peknight.cloudflare.zone.codec.instances.zoneStatus.given
import com.peknight.cloudflare.zone.query.ListZonesQuery
import com.peknight.codec.Codec
import com.peknight.codec.configuration.CodecConfiguration
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.sum.{NullType, NumberType, ObjectType, StringType}

trait ListZonesQueryInstances:
  given codecListZonesQuery[F[_], S](using CodecConfiguration, Monad[F], ObjectType[S], NullType[S], NumberType[S], StringType[S])
  : Codec[F, S, Cursor[S], ListZonesQuery] =
    Codec.derived[F, S, ListZonesQuery]
end ListZonesQueryInstances
object ListZonesQueryInstances extends ListZonesQueryInstances
