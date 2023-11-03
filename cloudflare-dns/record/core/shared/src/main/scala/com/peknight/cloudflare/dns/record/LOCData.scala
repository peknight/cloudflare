package com.peknight.cloudflare.dns.record

case class LOCData(
                    altitude: Double, latDegrees: Double, latDirection: LatitudeDirection, latMinutes: Double,
                    latSeconds: Double, longDegrees: Double, longDirection: LongitudeDirection, longMinutes: Double,
                    longSeconds: Double, precisionHorz: Double, precisionVert: Double, size: Double
                  )
