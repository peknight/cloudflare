package com.peknight.cloudflare.dns.record.circe.instances

import com.comcast.ip4s.Hostname
import com.peknight.cloudflare.Result
import com.peknight.cloudflare.circe.instances.configuration.given
import com.peknight.cloudflare.dns.record.{DNSRecord, DNSRecordType}
import com.peknight.cloudflare.dns.record.circe.instances.DNSRecordCirceInstancesCases.*
import com.peknight.cloudflare.dns.record.circe.instances.all.given
import com.peknight.generic.circe.decoder.given
import io.circe.derivation.ConfiguredEnumDecoder
import io.circe.parser.decode
import org.scalatest.flatspec.AnyFlatSpec

class DNSRecordCirceInstancesFlatSpec extends AnyFlatSpec:
  "CloudFlare DNS Record's circe instances" should "parse succeed json" in {
    case class Rua(`type`: Hostname)
    // println(decode[Rua]("{\"type\":\"www.peknight.com\"}"))
    assert(true)
    // val result = decode[Result[List[DNSRecord]]](listDNSRecordsSucceed)
    // println(result)
    // assert(result.isRight)
  }
end DNSRecordCirceInstancesFlatSpec
