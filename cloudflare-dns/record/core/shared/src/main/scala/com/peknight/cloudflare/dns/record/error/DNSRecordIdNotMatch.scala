package com.peknight.cloudflare.dns.record.error

import com.peknight.error.Error

case class DNSRecordIdNotMatch(actual: DNSRecordId, expected: DNSRecordId) extends Error:
 override def lowPriorityMessage: Option[String] = Some(s"dns record id not match, expected: $expected, actual: $actual")
end DNSRecordIdNotMatch
