package com.peknight.cloudflare.dns.record

import cats.syntax.applicative.*
import cats.{Applicative, Eq, Show}
import com.peknight.codec.Codec
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.sum.{ObjectType, StringType}

case class DNSRecordId(id: String) extends AnyVal
object DNSRecordId:
  given stringCodecDNSRecordId[F[_] : Applicative]: Codec[F, String, String, DNSRecordId] =
    Codec.map[F, String, String, DNSRecordId](_.id)(DNSRecordId.apply)

  def codecDNSRecordIdS[F[_] : Applicative, S: {StringType, Show}]: Codec[F, S, Cursor[S], DNSRecordId] =
    Codec.codecS[F, S, DNSRecordId]

  def codecDNSRecordIdObjectS[F[_], S](using applicative: Applicative[F], objectType: ObjectType[S],
                                       stringType: StringType[S], show: Show[S]): Codec[F, S, Cursor[S], DNSRecordId] =
    val key = "id"
    Codec.cursor[F, S, DNSRecordId](id => objectType.to(objectType.singleton(key, stringType.to(id.id))).pure[F]) {
      cursor => codecDNSRecordIdS[F, S].decode(cursor.downField(key))
    }

  given eqDNSRecordId: Eq[DNSRecordId] = Eq.fromUniversalEquals[DNSRecordId]
  given showDNSRecordId: Show[DNSRecordId] = Show.fromToString[DNSRecordId]
end DNSRecordId
