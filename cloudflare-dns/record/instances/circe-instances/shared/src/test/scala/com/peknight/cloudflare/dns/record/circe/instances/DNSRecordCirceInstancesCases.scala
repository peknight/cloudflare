package com.peknight.cloudflare.dns.record.circe.instances

object DNSRecordCirceInstancesCases:
  private[instances] val listDnsRecordsSucceed =
    """
      |{
      |    "result":[
      |        {
      |            "id":"dr1",
      |            "zone_id":"z1",
      |            "zone_name":"zn1",
      |            "name":"drn1",
      |            "type":"A",
      |            "content":"127.0.0.1",
      |            "proxiable":true,
      |            "proxied":false,
      |            "ttl":1,
      |            "locked":false,
      |            "meta":{
      |                "auto_added":false,
      |                "managed_by_apps":false,
      |                "managed_by_argo_tunnel":false,
      |                "source":"primary"
      |            },
      |            "comment":null,
      |            "tags":[
      |
      |            ],
      |            "created_on":"2019-10-23T08:30:31.112072Z",
      |            "modified_on":"2022-02-11T09:30:26.143901Z"
      |        },
      |        {
      |            "id":"dr2",
      |            "zone_id":"z1",
      |            "zone_name":"zn1",
      |            "name":"drn2",
      |            "type":"A",
      |            "content":"127.0.0.1",
      |            "proxiable":false,
      |            "proxied":false,
      |            "ttl":1,
      |            "locked":false,
      |            "meta":{
      |                "auto_added":false,
      |                "managed_by_apps":false,
      |                "managed_by_argo_tunnel":false,
      |                "source":"primary"
      |            },
      |            "comment":null,
      |            "tags":[
      |
      |            ],
      |            "created_on":"2019-10-23T08:29:08.603154Z",
      |            "modified_on":"2019-10-23T08:29:08.603154Z"
      |        },
      |        {
      |            "id":"dr3",
      |            "zone_id":"z1",
      |            "zone_name":"zn1",
      |            "name":"drn3",
      |            "type":"A",
      |            "content":"127.0.0.1",
      |            "proxiable":true,
      |            "proxied":true,
      |            "ttl":1,
      |            "locked":false,
      |            "meta":{
      |                "auto_added":false,
      |                "managed_by_apps":false,
      |                "managed_by_argo_tunnel":false,
      |                "source":"primary"
      |            },
      |            "comment":null,
      |            "tags":[
      |
      |            ],
      |            "created_on":"2021-07-29T12:14:38.42497Z",
      |            "modified_on":"2022-02-28T03:07:59.579295Z"
      |        },
      |        {
      |            "id":"dr4",
      |            "zone_id":"z1",
      |            "zone_name":"zn1",
      |            "name":"drn4",
      |            "type":"AAAA",
      |            "content":"::1",
      |            "proxiable":true,
      |            "proxied":false,
      |            "ttl":1,
      |            "locked":false,
      |            "meta":{
      |                "auto_added":false,
      |                "managed_by_apps":false,
      |                "managed_by_argo_tunnel":false,
      |                "source":"primary"
      |            },
      |            "comment":null,
      |            "tags":[
      |
      |            ],
      |            "created_on":"2022-07-06T08:20:55.472925Z",
      |            "modified_on":"2022-07-06T08:20:55.472925Z"
      |        }
      |    ],
      |    "success":true,
      |    "errors":[
      |
      |    ],
      |    "messages":[
      |
      |    ],
      |    "result_info":{
      |        "page":1,
      |        "per_page":100,
      |        "count":23,
      |        "total_count":23,
      |        "total_pages":1
      |    }
      |}
    """.stripMargin
end DNSRecordCirceInstancesCases
