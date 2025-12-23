package com.peknight.cloudflare.dns.record

import cats.Id
import com.peknight.cloudflare.Result
import com.peknight.cloudflare.dns.record.DNSRecord
import com.peknight.cloudflare.dns.record.DNSRecordCirceInstancesCases.*
import com.peknight.codec.circe.parser.decode
import com.peknight.codec.circe.sum.jsonType.given
import org.scalatest.flatspec.AnyFlatSpec

class DNSRecordCirceInstancesFlatSpec extends AnyFlatSpec:
  "CloudFlare DNS Record's circe instances" should "parse succeed json" in {
    val result = decode[Id, Result[List[DNSRecord]]](listDNSRecordsSucceed)
    assert(result.isRight)
  }
end DNSRecordCirceInstancesFlatSpec
