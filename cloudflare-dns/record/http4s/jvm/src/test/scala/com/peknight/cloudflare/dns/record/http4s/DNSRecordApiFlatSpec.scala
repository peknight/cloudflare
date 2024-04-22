package com.peknight.cloudflare.dns.record.http4s

import cats.Id
import cats.effect.IO
import cats.effect.testing.scalatest.AsyncIOSpec
import cats.syntax.option.*
import com.comcast.ip4s.Ipv4Address
import com.peknight.codec.ip4s.instances.host.stringCodecIpv4Address
import com.peknight.cloudflare.dns.record.DNSRecordType.A
import com.peknight.cloudflare.dns.record.body.DNSRecordBody
import com.peknight.cloudflare.dns.record.query.ListDNSRecordsQuery
import com.peknight.cloudflare.dns.record.query.Order.Type
import com.peknight.cloudflare.query.Direction.Desc
import com.peknight.cloudflare.test.{PekDNSRecord, PekToken, PekZone}
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
      .use(client => DNSRecordApi[IO](client)(dsl.io).listDNSRecords(PekZone.zoneId)(query)(PekToken.token))
      .asserting{ result =>
        println(result)
        assert(result.result.isDefined)
      }
  }
  "CloudFlare DNS Records for a Zone Api Overwrite DNS Record" should "succeed" in {
    val content1 = stringCodecIpv4Address[Id].decode("127.0.0.1").fold(throw _, identity)
    val content2 = stringCodecIpv4Address[Id].decode("192.168.0.1").fold(throw _, identity)
    val content3 = stringCodecIpv4Address[Id].decode("192.168.1.1").fold(throw _, identity)
    val body1 = DNSRecordBody.A(content1, "test.peknight.com", false.some)
    val body2 = body1.copy(content = content2)
    val body3 = body1.copy(content = content3)
    EmberClientBuilder.default[IO].build
      .use { client =>
        val api = DNSRecordApi[IO](client)(dsl.io)
        for
          createResult <- api.createDNSRecord(PekZone.zoneId)(body1)(PekToken.token)
          _ <- IO.println(createResult)
        yield createResult
        api.overwriteDNSRecord(PekZone.zoneId, PekDNSRecord.dnsRecordId)(body)(PekToken.token)
      }
      .asserting{ result =>
        println(result)
        assert(result.result.isDefined)
      }
  }

end DNSRecordApiFlatSpec
