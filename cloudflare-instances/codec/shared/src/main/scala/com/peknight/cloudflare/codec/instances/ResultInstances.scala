package com.peknight.cloudflare.codec.instances

import cats.{Monad, Show}
import cats.data.NonEmptyList
import com.peknight.cloudflare.Result
import com.peknight.cloudflare.codec.instances.error.given
import com.peknight.cloudflare.codec.instances.message.given
import com.peknight.cloudflare.codec.instances.resultInfo.given
import com.peknight.codec.config.CodecConfig
import com.peknight.codec.cursor.Cursor
import com.peknight.codec.sum.*
import com.peknight.codec.{Codec, Decoder, Encoder}

trait ResultInstances:
  private val memberNameMap: Map[String, String] = Map("msgs" -> "messages")
  given codecResult[F[_], S, A](using config: CodecConfig, monad: Monad[F], objectType: ObjectType[S],
                                nullType: NullType[S], arrayType: ArrayType[S], numberType: NumberType[S],
                                booleanType: BooleanType[S], stringType: StringType[S],
                                encoder: Encoder[F, S, A], decoder: Decoder[F, Cursor[S], A], show: Show[S])
  : Codec[F, S, Cursor[S], Result[A]] =
    Codec.derived[F, S, Result[A]](using config.withTransformMemberNames(memberName =>
      memberNameMap.get(memberName).map(NonEmptyList.one).getOrElse(config.transformMemberNames(memberName))
    ))
end ResultInstances
object ResultInstances extends ResultInstances
