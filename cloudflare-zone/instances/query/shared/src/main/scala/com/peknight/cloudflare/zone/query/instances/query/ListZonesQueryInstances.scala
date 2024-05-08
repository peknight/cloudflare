package com.peknight.cloudflare.zone.query.instances.query

import cats.Monad
import com.peknight.cloudflare.codec.instances.query.`match`.given
import com.peknight.cloudflare.codec.instances.query.direction.given
import com.peknight.cloudflare.codec.instances.query.order.given
import com.peknight.cloudflare.query.instances.query.stringParam.given
import com.peknight.cloudflare.zone.codec.instances.accountId.given
import com.peknight.cloudflare.zone.codec.instances.zoneStatus.given
import com.peknight.cloudflare.zone.query.{Account, ListZonesQuery}
import com.peknight.codec.Codec
import com.peknight.codec.configuration.CodecConfiguration
import com.peknight.codec.cursor.Cursor
import com.peknight.query.Query
import com.peknight.query.codec.id.Encoder

trait ListZonesQueryInstances:
  given codecAccount[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Query, Cursor[Query], Account] =
    Codec.derived[F, Query, Account]
  given codecListZonesQuery[F[_]](using CodecConfiguration, Monad[F]): Codec[F, Query, Cursor[Query], ListZonesQuery] =
    Codec.derived[F, Query, ListZonesQuery]
end ListZonesQueryInstances
object ListZonesQueryInstances extends ListZonesQueryInstances
