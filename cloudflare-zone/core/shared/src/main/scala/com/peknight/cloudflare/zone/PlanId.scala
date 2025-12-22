package com.peknight.cloudflare.zone

import cats.{Applicative, Show}
import com.peknight.codec.Codec
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.sum.StringType

case class PlanId(id: String) extends AnyVal
object PlanId:
  given stringCodecPlanId[F[_]: Applicative]: Codec[F, String, String, PlanId] =
    Codec.map[F, String, String, PlanId](_.id)(PlanId.apply)

  given codecPlanIdS[F[_]: Applicative, S: {StringType, Show}]: Codec[F, S, Cursor[S], PlanId] =
    Codec.codecS[F, S, PlanId]
end PlanId
