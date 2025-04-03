package com.peknight.cloudflare.codec.instances.query

import cats.Applicative
import com.peknight.cloudflare.query.Order
import com.peknight.codec.Codec
import com.peknight.codec.configuration.{CodecConfiguration, Configuration}
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.derivation.EnumCodecDerivation
import com.peknight.codec.sum.StringType
import com.peknight.commons.string.syntax.cases.splitByCase
import com.peknight.generic.Generic

import scala.reflect.ClassTag

trait OrderInstances:
  given stringCodecOrder[F[_], O <: Order](using Applicative[F], Generic.Sum[O])
  : Codec[F, String, String, O] =
    EnumCodecDerivation.unsafeDerived[F, String, String, O](
      using CodecConfiguration.default.withTransformConstructorName(_.splitByCase.map(_.toLowerCase).mkString("."))
    )

  given codecOrderS[F[_], S, O <: Order](using Configuration, Applicative[F], StringType[S], Generic.Sum[O], ClassTag[O])
  : Codec[F, S, Cursor[S], O] =
    Codec.codecS[F, S, O]
end OrderInstances
object OrderInstances extends OrderInstances
