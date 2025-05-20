package com.peknight.cloudflare.query

import cats.Show

case class StringOptionParam(exact: Option[String], absent: Option[Unit] = None, contains: Option[String] = None,
                             endsWith: Option[String] = None, present: Option[Unit] = None,
                             startsWith: Option[String] = None)
object StringOptionParam:
  given showStringOptionParam: Show[StringOptionParam] = Show.fromToString[StringOptionParam]
end StringOptionParam
