package com.peknight.cloudflare.dns.record

import com.comcast.ip4s.{Hostname, Port}

case class SRVData(name: Hostname, port: Port, priority: Int, proto: String, service: String, target: Hostname, weight: Int)
