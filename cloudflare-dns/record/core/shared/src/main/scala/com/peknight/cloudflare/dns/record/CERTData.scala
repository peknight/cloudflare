package com.peknight.cloudflare.dns.record

case class CERTData(algorithm: Int, certificate: String, keyTag: Int, `type`: Int)
