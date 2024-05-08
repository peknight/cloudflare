package com.peknight.cloudflare.zone.codec.instances

import cats.Applicative
import com.peknight.cloudflare.zone.PlanId
import com.peknight.codec.Codec
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.sum.StringType

trait PlanIdInstances:
  given stringCodecPlanId[F[_]: Applicative]: Codec[F, String, String, PlanId] =
    Codec.map[F, String, String, PlanId](_.id)(PlanId.apply)

  given codecPlanIdS[F[_]: Applicative, S: StringType]: Codec[F, S, Cursor[S], PlanId] = Codec.codecS[F, S, PlanId]
end PlanIdInstances
object PlanIdInstances extends PlanIdInstances
