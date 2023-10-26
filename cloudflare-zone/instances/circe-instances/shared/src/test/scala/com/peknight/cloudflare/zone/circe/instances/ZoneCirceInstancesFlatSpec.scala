package com.peknight.cloudflare.zone.circe.instances

import org.scalatest.flatspec.AnyFlatSpec
import com.peknight.cloudflare.Result
import com.peknight.cloudflare.circe.instances.all.given
import com.peknight.cloudflare.zone.Zone
import com.peknight.cloudflare.zone.circe.instances.all.given
import io.circe.parser.decode

class ZoneCirceInstancesFlatSpec extends AnyFlatSpec:

  private[this] val listZonesFailed =
    """
      |{
      |  "success" : false,
      |  "errors" : [
      |    {
      |      "code" : 6003,
      |      "message" : "Invalid request headers",
      |      "error_chain" : [
      |        {
      |          "code" : 6111,
      |          "message" : "Invalid format for Authorization header"
      |        }
      |      ]
      |    }
      |  ],
      |  "messages" : [
      |  ],
      |  "result" : null
      |}
    """.stripMargin
  private[this] val listZonesSucceed =
    """
      |{
      |  "result" : [
      |    {
      |      "id" : "<zone_id>",
      |      "name" : "<zone_name>",
      |      "status" : "active",
      |      "paused" : false,
      |      "type" : "full",
      |      "development_mode" : 0,
      |      "name_servers" : [
      |        "jade.ns.cloudflare.com",
      |        "jason.ns.cloudflare.com"
      |      ],
      |      "original_name_servers" : [
      |        "jade.ns.cloudflare.com",
      |        "jason.ns.cloudflare.com"
      |      ],
      |      "original_registrar" : "alibaba cloud computing (beijing) co., ltd.",
      |      "original_dnshost" : null,
      |      "modified_on" : "2021-06-10T15:17:27.987721Z",
      |      "created_on" : "2019-05-23T10:35:23.981698Z",
      |      "activated_on" : "2019-05-23T10:36:59.293475Z",
      |      "meta" : {
      |        "step" : 3,
      |        "custom_certificate_quota" : 0,
      |        "page_rule_quota" : 3,
      |        "phishing_detected" : false,
      |        "multiple_railguns_allowed" : false
      |      },
      |      "owner" : {
      |        "id" : null,
      |        "type" : "user",
      |        "email" : null
      |      },
      |      "account" : {
      |        "id" : "<account_id>",
      |        "name" : "<account_name>"
      |      },
      |      "tenant" : {
      |        "id" : null,
      |        "name" : null
      |      },
      |      "tenant_unit" : {
      |        "id" : null
      |      },
      |      "permissions" : [
      |        "#dns_records:edit",
      |        "#dns_records:read",
      |        "#zone:read"
      |      ],
      |      "plan" : {
      |        "id" : "<plan_id>",
      |        "name" : "Free Website",
      |        "price" : 0,
      |        "currency" : "USD",
      |        "frequency" : "",
      |        "is_subscribed" : false,
      |        "can_subscribe" : false,
      |        "legacy_id" : "free",
      |        "legacy_discount" : false,
      |        "externally_managed" : false
      |      }
      |    }
      |  ],
      |  "result_info" : {
      |    "page" : 1,
      |    "per_page" : 20,
      |    "total_pages" : 1,
      |    "count" : 1,
      |    "total_count" : 1
      |  },
      |  "success" : true,
      |  "errors" : [
      |  ],
      |  "messages" : [
      |  ]
      |}
    """.stripMargin

  "CloudFlare Zone's circe instances" should "succeed" in {
    val result = decode[Result[List[Zone]]](listZonesSucceed)
    println(result)
    assert(result.isRight)
  }
end ZoneCirceInstancesFlatSpec
