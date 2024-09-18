package com.peknight.cloudflare.dns.record.circe.instances

import cats.Id
import com.peknight.cloudflare.Result
import com.peknight.cloudflare.circe.instances.result.given
import com.peknight.cloudflare.codec.instances.configuration.given
import com.peknight.cloudflare.dns.record.DNSRecord
import com.peknight.cloudflare.dns.record.circe.instances.DNSRecordCirceInstancesCases.*
import com.peknight.cloudflare.dns.record.codec.instances.dnsRecord.given
import com.peknight.codec.circe.parser.decode
import com.peknight.codec.circe.sum.jsonType.given
import org.scalatest.flatspec.AnyFlatSpec

class DNSRecordCirceInstancesFlatSpec extends AnyFlatSpec:
  "CloudFlare DNS Record's circe instances" should "parse succeed json" in {
    val result = decode[Id, Result[List[DNSRecord]]](listDNSRecordsSucceed)
    println(result)
    assert(result.isRight)
  }
end DNSRecordCirceInstancesFlatSpec
