package com.peknight.cloudflare.zone.http4s.instances

import com.peknight.cloudflare.zone.ZoneId
import org.http4s.Uri.Path.Segment
import org.http4s.Uri.Path.SegmentEncoder

trait ZoneIdInstances:
  given SegmentEncoder[ZoneId] with
    def toSegment(a: ZoneId): Segment = Segment(a.id)
  end given
end ZoneIdInstances
object ZoneIdInstances extends ZoneIdInstances
