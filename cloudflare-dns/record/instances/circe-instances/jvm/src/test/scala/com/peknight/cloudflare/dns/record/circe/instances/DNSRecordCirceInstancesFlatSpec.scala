package com.peknight.cloudflare.dns.record.circe.instances

import com.peknight.cloudflare.Result
import com.peknight.cloudflare.circe.instances.result.given
import com.peknight.cloudflare.dns.record.DNSRecord
import com.peknight.cloudflare.dns.record.circe.instances.DNSRecordCirceInstancesCases.*
import com.peknight.cloudflare.dns.record.circe.instances.dnsRecord.given
import io.circe.parser.decode
import org.scalatest.flatspec.AnyFlatSpec

class DNSRecordCirceInstancesFlatSpec extends AnyFlatSpec:
  "CloudFlare DNS Record's circe instances" should "parse succeed json" in {
    // val result = decode[Result[List[DNSRecord]]](listDNSRecordsSucceed)
    // println(result)
    // assert(result.isRight)
  }
end DNSRecordCirceInstancesFlatSpec
