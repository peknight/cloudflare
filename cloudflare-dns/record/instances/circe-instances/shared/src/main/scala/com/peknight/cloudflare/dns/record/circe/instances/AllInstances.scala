package com.peknight.cloudflare.dns.record.circe.instances

trait AllInstances extends DNSRecordIdInstances
  with DNSRecordTypeInstances
  with LatitudeDirectionInstances
  with LongitudeDirectionInstances
object AllInstances extends AllInstances
