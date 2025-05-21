package com.peknight.cloudflare.zone.query.instances.query

import cats.Monad
import com.peknight.cloudflare.zone.codec.instances.query.listZonesQuery.codecListZonesQuery
import com.peknight.cloudflare.zone.query.ListZonesQuery
import com.peknight.codec.Codec
import com.peknight.codec.config.CodecConfig
import com.peknight.codec.cursor.Cursor
import com.peknight.query.Query

trait ListZonesQueryInstances:
  given queryCodecListZonesQuery[F[_]](using CodecConfig, Monad[F]): Codec[F, Query, Cursor[Query], ListZonesQuery] =
    codecListZonesQuery[F, Query]
end ListZonesQueryInstances
object ListZonesQueryInstances extends ListZonesQueryInstances
