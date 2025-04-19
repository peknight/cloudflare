package com.peknight.cloudflare.dns.record

import cats.Show

enum DNSRecordType:
  case A, AAAA, CAA, CERT, CNAME, DNSKEY, DS, HTTPS, LOC, MX, NAPTR, NS, OPENPGPKEY, PTR, SMIMEA, SRV, SSHFP, SVCB, TLSA, TXT, URI
end DNSRecordType
object DNSRecordType:
  given showDNSRecordType: Show[DNSRecordType] = Show.fromToString[DNSRecordType]
end DNSRecordType
