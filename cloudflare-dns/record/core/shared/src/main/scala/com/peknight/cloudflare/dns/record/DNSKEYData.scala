package com.peknight.cloudflare.dns.record

case class DNSKEYData(algorithm: Int, flags: Int, protocol: Int, publicKey: String)
