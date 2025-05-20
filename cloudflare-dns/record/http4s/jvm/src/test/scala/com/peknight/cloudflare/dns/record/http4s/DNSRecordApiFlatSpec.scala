package com.peknight.cloudflare.dns.record.http4s

import cats.data.EitherT
import cats.effect.IO
import cats.effect.testing.scalatest.AsyncIOSpec
import cats.syntax.option.*
import com.comcast.ip4s.ipv4
import com.peknight.api.syntax.result.asError as resultAsError
import com.peknight.cloudflare.dns.record.DNSRecordType.A
import com.peknight.cloudflare.dns.record.body.DNSRecordBody
import com.peknight.cloudflare.dns.record.query.ListDNSRecordsQuery
import com.peknight.cloudflare.dns.record.query.Order.Type
import com.peknight.cloudflare.query.Direction.Desc
import com.peknight.cloudflare.zone.codec.instances.config.cloudflareZoneConfig.given
import com.peknight.cloudflare.zone.config.CloudflareZoneConfig
import com.peknight.codec.Decoder
import com.peknight.codec.reader.Key
import com.peknight.error.Error
import com.peknight.error.syntax.applicativeError.asError
import com.peknight.logging.syntax.eitherT.log
import org.http4s.client.Client
import org.http4s.ember.client.EmberClientBuilder
import org.scalatest.flatspec.AsyncFlatSpec
import org.typelevel.log4cats.Logger
import org.typelevel.log4cats.slf4j.Slf4jLogger

class DNSRecordApiFlatSpec extends AsyncFlatSpec with AsyncIOSpec:
  "CloudFlare DNS Records for a Zone Api List DNS Records" should "succeed" in {
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
            logger <- EitherT(Slf4jLogger.fromClass[IO](classOf[DNSRecordApiFlatSpec]).asError)
            given Logger[IO] = logger
            config <- EitherT(Decoder.load[IO, CloudflareZoneConfig](Key("CLOUDFLARE")))
              .log[Unit]("DNSRecordApiFlatSpec#loadConfig")
            dnsRecords <- EitherT(DNSRecordApi[IO](config.token).listDNSRecords(config.zoneId)(query).resultAsError)
              .log("DNSRecordApiFlatSpec#listDNSRecords", query.some)
          yield
            dnsRecords
        eitherT.value
      }
      .asserting(either => assert(either.isRight))
  }

  "CloudFlare DNS Records for a Zone Api Overwrite DNS Record" should "succeed" in {
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
            logger <- EitherT(Slf4jLogger.fromClass[IO](classOf[DNSRecordApiFlatSpec]).asError)
            given Logger[IO] = logger
            config <- EitherT(Decoder.load[IO, CloudflareZoneConfig](Key("CLOUDFLARE")))
            api = DNSRecordApi[IO](config.token)
            dnsRecord <- EitherT(api.createDNSRecord(config.zoneId)(body1).resultAsError)
              .log("DNSRecordApiFlatSpec#createDNSRecord", body1.some)
            dnsRecord1 <- EitherT(api.overwriteDNSRecord(config.zoneId, dnsRecord.id)(body2).resultAsError)
              .log("DNSRecordApiFlatSpec#overwriteDNSRecord", body2.some)
            dnsRecord2 <- EitherT(api.updateDNSRecord(config.zoneId, dnsRecord1.id)(body3).resultAsError)
              .log("DNSRecordApiFlatSpec#updateDNSRecord", body3.some)
            dnsRecord3 <- EitherT(api.dnsRecordDetails(config.zoneId, dnsRecord2.id).resultAsError)
              .log("DNSRecordApiFlatSpec#dnsRecordDetails", dnsRecord2.id.some)
            dnsRecordId <- EitherT(api.deleteDNSRecord(config.zoneId, dnsRecord3.id).resultAsError)
              .log("DNSRecordApiFlatSpec#deleteDNSRecord", dnsRecord3.id.some)
          yield
            dnsRecordId
        eitherT.value
      }
      .asserting(either => assert(either.isRight))
  }


end DNSRecordApiFlatSpec
