package com.peknight.cloudflare.dns.record

import cats.{Monad, Show}
import com.peknight.cloudflare.config.given
import com.peknight.codec.Codec
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.sum.{NullType, NumberType, ObjectType, StringType}

case class LOCData(
                    altitude: Double, latDegrees: Double, latDirection: LatitudeDirection, latMinutes: Double,
                    latSeconds: Double, longDegrees: Double, longDirection: LongitudeDirection, longMinutes: Double,
                    longSeconds: Double, precisionHorz: Double, precisionVert: Double, size: Double
                  )
object LOCData:
  given codecDNSRecordLOCData[F[_] : Monad, S: {ObjectType, NullType, NumberType, StringType, Show}]
  : Codec[F, S, Cursor[S], LOCData] =
    Codec.derived[F, S, LOCData]

  given showDNSRecordLOCData: Show[LOCData] = Show.fromToString[LOCData]
end LOCData
