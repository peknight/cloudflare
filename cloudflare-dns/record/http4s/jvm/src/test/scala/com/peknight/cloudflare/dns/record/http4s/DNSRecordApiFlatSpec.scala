package com.peknight.cloudflare.dns.record.http4s

import cats.data.EitherT
import cats.effect.IO
import cats.effect.testing.scalatest.AsyncIOSpec
import cats.syntax.option.*
import com.comcast.ip4s.ipv4
import com.peknight.api.syntax.result.asET as resultAsET
import com.peknight.cloudflare.dns.record.DNSRecordType.A
import com.peknight.cloudflare.dns.record.body.DNSRecordBody
import com.peknight.cloudflare.dns.record.query.ListDNSRecordsQuery
import com.peknight.cloudflare.dns.record.query.Order.Type
import com.peknight.cloudflare.query.Direction.Desc
import com.peknight.cloudflare.zone.config.CloudflareZoneConfig
import com.peknight.codec.Decoder
import com.peknight.codec.reader.Key
import com.peknight.error.Error
import com.peknight.error.syntax.applicativeError.asET
import com.peknight.logging.syntax.eitherT.log
import org.http4s.client.Client
import org.http4s.ember.client.EmberClientBuilder
import org.scalatest.flatspec.AsyncFlatSpec
import org.typelevel.log4cats.Logger
import org.typelevel.log4cats.slf4j.Slf4jLogger

class DNSRecordApiFlatSpec extends AsyncFlatSpec with AsyncIOSpec:
  "CloudFlare DNS Records for a Zone Api List DNS Records" should "pass" in {
    val query = ListDNSRecordsQuery(
      `type` = A.some,
      direction = Desc.some,
      order = Type.some
    )
    EmberClientBuilder.default[IO].build
      .use { client =>
        given Client[IO] = client
        val eitherT =
          for
            logger <- Slf4jLogger.fromClass[IO](classOf[DNSRecordApiFlatSpec]).asET
            given Logger[IO] = logger
            // 设置环境变量CLOUDFLARE_TOKEN及CLOUDFLARE_ZONE_ID
            config <- EitherT(Decoder.load[IO, CloudflareZoneConfig](Key("cloudflare")))
              .log[Unit]("DNSRecordApiFlatSpec#loadConfig")
            dnsRecords <- DNSRecordApi[IO](config.token).listDNSRecords(config.zoneId)(query).resultAsET
              .log("DNSRecordApiFlatSpec#listDNSRecords", query.some)
          yield
            dnsRecords
        eitherT.value
      }
      .asserting(either => assert(either.isRight))
  }

  "CloudFlare DNS Records for a Zone Api Overwrite DNS Record" should "pass" in {
    val content1 = ipv4"127.0.0.1"
    val content2 = ipv4"192.168.0.1"
    val content3 = ipv4"192.168.1.1"
    val body1 = DNSRecordBody.A(content1, "test.peknight.com", false.some)
    val body2 = body1.copy(content = content2)
    val body3 = body1.copy(content = content3)
    EmberClientBuilder.default[IO].build
      .use { client =>
        given Client[IO] = client
        val eitherT =
          for
            logger <- Slf4jLogger.fromClass[IO](classOf[DNSRecordApiFlatSpec]).asET
            given Logger[IO] = logger
            // 设置环境变量CLOUDFLARE_TOKEN及CLOUDFLARE_ZONE_ID
            config <- EitherT(Decoder.load[IO, CloudflareZoneConfig](Key("cloudflare")))
            api = DNSRecordApi[IO](config.token)
            dnsRecord <- api.createDNSRecord(config.zoneId)(body1).resultAsET
              .log("DNSRecordApiFlatSpec#createDNSRecord", body1.some)
            dnsRecord1 <- api.overwriteDNSRecord(config.zoneId, dnsRecord.id)(body2).resultAsET
              .log("DNSRecordApiFlatSpec#overwriteDNSRecord", body2.some)
            dnsRecord2 <- api.updateDNSRecord(config.zoneId, dnsRecord1.id)(body3).resultAsET
              .log("DNSRecordApiFlatSpec#updateDNSRecord", body3.some)
            dnsRecord3 <- api.dnsRecordDetails(config.zoneId, dnsRecord2.id).resultAsET
              .log("DNSRecordApiFlatSpec#dnsRecordDetails", dnsRecord2.id.some)
            dnsRecordId <- api.deleteDNSRecord(config.zoneId, dnsRecord3.id).resultAsET
              .log("DNSRecordApiFlatSpec#deleteDNSRecord", dnsRecord3.id.some)
          yield
            dnsRecordId
        eitherT.value
      }
      .asserting(either => assert(either.isRight))
  }


end DNSRecordApiFlatSpec
