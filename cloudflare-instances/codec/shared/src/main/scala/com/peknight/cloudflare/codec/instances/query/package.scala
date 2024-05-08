package com.peknight.cloudflare.codec.instances

package object query:
  object all extends DirectionInstances with MatchInstances with OrderInstances
  object direction extends DirectionInstances
  object `match` extends MatchInstances
  object order extends OrderInstances
end query
