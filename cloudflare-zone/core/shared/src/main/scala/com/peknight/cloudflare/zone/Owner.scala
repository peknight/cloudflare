package com.peknight.cloudflare.zone

case class Owner(id: Option[OwnerId], name: Option[String], `type`: String, email: Option[String])
