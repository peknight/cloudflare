package com.peknight.cloudflare.query

trait QueryParam:
  def direction: Option[Direction]
  def `match`: Option[Match]
  def order: Option[Order]
  def page: Option[Int]
  def perPage: Option[Int]
end QueryParam
