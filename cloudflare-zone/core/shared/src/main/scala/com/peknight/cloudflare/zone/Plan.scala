package com.peknight.cloudflare.zone

import cats.{Monad, Show}
import com.peknight.cloudflare.config.given
import com.peknight.codec.Codec
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.sum.*

case class Plan(
                 id: PlanId,
                 name: String,
                 price: BigDecimal,
                 currency: String,
                 frequency: String,
                 isSubscribed: Boolean,
                 canSubscribe: Boolean,
                 legacyId: String,
                 legacyDiscount: Boolean,
                 externallyManaged: Boolean
               )
object Plan:
  given codecPlan[F[_]: Monad, S: {ObjectType, NullType, NumberType, BooleanType, StringType, Show}]
  : Codec[F, S, Cursor[S], Plan] =
    Codec.derived[F, S, Plan]
end Plan
