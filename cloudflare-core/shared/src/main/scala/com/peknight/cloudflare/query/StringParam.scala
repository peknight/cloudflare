package com.peknight.cloudflare.query

case class StringParam(equal: Option[String] = None, notEqual: Option[String] = None, startsWith: Option[String] = None,
                       endsWith: Option[String] = None, contains: Option[String] = None,
                       startsWithCaseSensitive: Option[String] = None, endsWithCaseSensitive: Option[String] = None,
                       containsCaseSensitive: Option[String] = None)
