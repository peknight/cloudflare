package com.peknight.cloudflare.dns.record

import com.comcast.ip4s.{Hostname, Port}

case class SRVData(port: Port, priority: Int, target: Hostname, weight: Int)
