package com.peknight.cloudflare

import com.peknight.api.pagination.Pagination

case class ResultInfo(
                       // Total number of results for the requested service
                       count: Int,
                       // Current page within paginated list of results
                       page: Int,
                       // Number of results per page of results
                       perPage: Int,
                       // Total results available without any search parameters
                       totalCount: Int,
                       totalPages: Option[Int]
                     ) extends Pagination