package com.peknight.cloudflare.zone

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
