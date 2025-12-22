package com.peknight.cloudflare.query

import cats.{Applicative, Show}
import com.peknight.codec.Codec
import com.peknight.codec.config.CodecConfig
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.derivation.EnumCodecDerivation
import com.peknight.codec.sum.StringType
import com.peknight.commons.text.syntax.cases.splitByCase
import com.peknight.generic.Generic

import scala.reflect.ClassTag

trait Order
object Order:
  given stringCodecOrder[F[_], O <: Order](using Applicative[F], Generic.Sum[O])
  : Codec[F, String, String, O] =
    given CodecConfig = CodecConfig.default.withTransformConstructorName(_.splitByCase.map(_.toLowerCase).mkString("."))
    EnumCodecDerivation.unsafeDerived[F, String, String, O]

  given codecOrder[F[_]: Applicative, S: {StringType, Show}, O <: Order: {Generic.Sum, ClassTag}]
  : Codec[F, S, Cursor[S], O] =
    Codec.codecS[F, S, O]
end Order
