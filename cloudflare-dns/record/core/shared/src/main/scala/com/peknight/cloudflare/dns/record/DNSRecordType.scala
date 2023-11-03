package com.peknight.cloudflare.dns.record

enum DNSRecordType:
  case A, AAAA, CAA, CERT, CNAME, DNSKEY, DS, HTTPS, LOC, MX, NAPTR, NS, PTR, SMIMEA, SRV, SSHFP, SVCB, TLSA, TXT, URI
end DNSRecordType