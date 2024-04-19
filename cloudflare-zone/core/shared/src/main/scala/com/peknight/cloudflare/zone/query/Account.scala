package com.peknight.cloudflare.zone.query

import com.peknight.cloudflare.query.StringParam
import com.peknight.cloudflare.zone.AccountId

case class Account(id: Option[AccountId] = None, name: Option[StringParam] = None)
