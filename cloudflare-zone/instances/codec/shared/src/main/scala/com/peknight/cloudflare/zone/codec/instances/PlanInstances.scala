package com.peknight.cloudflare.zone.codec.instances

import cats.Monad
import com.peknight.cloudflare.zone.Plan
import com.peknight.cloudflare.zone.codec.instances.planId.given
import com.peknight.codec.Codec
import com.peknight.codec.configuration.CodecConfiguration
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.sum.*

trait PlanInstances:
  given codecPlan[F[_], S](using CodecConfiguration, Monad[F], ObjectType[S], NullType[S], NumberType[S],
                           BooleanType[S], StringType[S]): Codec[F, S, Cursor[S], Plan] =
    Codec.derived[F, S, Plan]
end PlanInstances
object PlanInstances extends PlanInstances
