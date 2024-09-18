package com.peknight.cloudflare.dns.record.http4s

import cats.Id
import cats.effect.IO
import cats.effect.testing.scalatest.AsyncIOSpec
import cats.syntax.either.*
import cats.syntax.flatMap.*
import cats.syntax.functor.*
import cats.syntax.option.*
import com.peknight.cats.ext.data.OptionEitherT
import com.peknight.cloudflare.Result
import com.peknight.cloudflare.dns.record.DNSRecordType.A
import com.peknight.cloudflare.dns.record.body.DNSRecordBody
import com.peknight.cloudflare.dns.record.query.ListDNSRecordsQuery
import com.peknight.cloudflare.dns.record.query.Order.Type
import com.peknight.cloudflare.query.Direction.Desc
import com.peknight.cloudflare.test.{PekToken, PekZone}
import com.peknight.codec.ip4s.instances.host.stringCodecIpv4Address
import com.peknight.error.Error
import org.http4s.client.dsl
import org.http4s.ember.client.EmberClientBuilder
import org.scalatest.flatspec.AsyncFlatSpec

class DNSRecordApiFlatSpec extends AsyncFlatSpec with AsyncIOSpec:
  "CloudFlare DNS Records for a Zone Api List DNS Records" should "succeed" in {
    val query = ListDNSRecordsQuery(
      `type` = A.some,
      direction = Desc.some,
      order = Type.some
    )
    EmberClientBuilder.default[IO].build
      .use(client => DNSRecordApi[IO](PekToken.token)(client)(dsl.io).listDNSRecords(PekZone.zoneId)(query))
      .asserting{ result =>
        println(result)
        assert(result.result.isDefined)
      }
  }

  extension [A] (io: IO[Result[A]])
    private def lift: OptionEitherT[IO, Error, A] =
      OptionEitherT(io.flatTap(IO.println).map(result =>
        if result.success then result.result.asRight[Error] else Error(result).asLeft[Option[A]]
      ))
  end extension

  "CloudFlare DNS Records for a Zone Api Overwrite DNS Record" should "succeed" in {
    val content1 = stringCodecIpv4Address[Id].decode("127.0.0.1").fold(throw _, identity)
    val content2 = stringCodecIpv4Address[Id].decode("192.168.0.1").fold(throw _, identity)
    val content3 = stringCodecIpv4Address[Id].decode("192.168.1.1").fold(throw _, identity)
    val body1 = DNSRecordBody.A(content1, "test.peknight.com", false.some)
    val body2 = body1.copy(content = content2)
    val body3 = body1.copy(content = content3)
    EmberClientBuilder.default[IO].build
      .use { client =>
        val api = DNSRecordApi[IO](PekToken.token)(client)(dsl.io)
        val run =
          for
            dnsRecord <- api.createDNSRecord(PekZone.zoneId)(body1).lift
            dnsRecord1 <- api.overwriteDNSRecord(PekZone.zoneId, dnsRecord.id)(body2).lift
            dnsRecord2 <- api.updateDNSRecord(PekZone.zoneId, dnsRecord1.id)(body3).lift
            dnsRecord3 <- api.dnsRecordDetails(PekZone.zoneId, dnsRecord2.id).lift
            dnsRecordId <- api.deleteDNSRecord(PekZone.zoneId, dnsRecord3.id).lift
          yield dnsRecordId
        run.value
      }
      .asserting{ result =>
        println(result)
        assert(result.exists(_.isDefined))
      }
  }


end DNSRecordApiFlatSpec
