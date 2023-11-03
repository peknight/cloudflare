package com.peknight.cloudflare.dns.record

case class DSData(algorithm: Int, digest: String, digestType: Int, keyTag: Int)
