package com.peknight.cloudflare.dns.record

case class NAPTRData(flags: String, order: Int, preference: Int, regex: String, replacement: String, service: String)
