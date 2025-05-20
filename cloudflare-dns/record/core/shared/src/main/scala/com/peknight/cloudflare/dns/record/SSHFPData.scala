package com.peknight.cloudflare.dns.record

import cats.Show

case class SSHFPData(algorithm: Int, fingerprint: String, `type`: Int)
object SSHFPData:
  given showDNSRecordSSHFPData: Show[SSHFPData] = Show.fromToString[SSHFPData]
end SSHFPData
