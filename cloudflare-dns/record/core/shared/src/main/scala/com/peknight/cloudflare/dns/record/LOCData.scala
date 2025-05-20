package com.peknight.cloudflare.dns.record

import cats.Show

case class LOCData(
                    altitude: Double, latDegrees: Double, latDirection: LatitudeDirection, latMinutes: Double,
                    latSeconds: Double, longDegrees: Double, longDirection: LongitudeDirection, longMinutes: Double,
                    longSeconds: Double, precisionHorz: Double, precisionVert: Double, size: Double
                  )
object LOCData:
  given showDNSRecordLOCData: Show[LOCData] = Show.fromToString[LOCData]
end LOCData
