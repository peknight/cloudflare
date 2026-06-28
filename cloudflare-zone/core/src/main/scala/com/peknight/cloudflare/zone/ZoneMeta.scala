package com.peknight.cloudflare.zone

import cats.{Monad, Show}
import com.peknight.cloudflare.config.given
import com.peknight.codec.Codec
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.sum.*

case class ZoneMeta(
                     cdnOnly: Option[Boolean],
                     customCertificateQuota: Int,
                     dnsOnly: Option[Boolean],
                     foundationDns: Option[Boolean],
                     pageRuleQuota: Int,
                     phishingDetected: Boolean,
                     step: Int,
                     multipleRailgunsAllowed: Option[Boolean]
                   )

object ZoneMeta:
  given codecZoneMeta[F[_]: Monad, S: {ObjectType, NullType, NumberType, BooleanType, StringType, Show}]
  : Codec[F, S, Cursor[S], ZoneMeta] =
    Codec.derived[F, S, ZoneMeta]
end ZoneMeta