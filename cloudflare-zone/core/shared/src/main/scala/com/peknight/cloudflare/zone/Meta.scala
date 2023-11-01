package com.peknight.cloudflare.zone

case class Meta(
                 cdnOnly: Option[Boolean],
                 customCertificateQuota: Int,
                 dnsOnly: Option[Boolean],
                 foundationDns: Option[Boolean],
                 pageRuleQuota: Int,
                 phishingDetected: Boolean,
                 step: Int,
                 multipleRailgunsAllowed: Option[Boolean]
               )
