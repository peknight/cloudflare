package com.peknight.cloudflare.test

import com.peknight.cloudflare.dns.record.DNSRecordId

trait CloudflareTestDNSRecord:
  def dnsRecordId: DNSRecordId
end CloudflareTestDNSRecord
