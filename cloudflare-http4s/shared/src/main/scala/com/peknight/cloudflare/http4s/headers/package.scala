package com.peknight.cloudflare.http4s

import com.peknight.cloudflare.Token
import org.http4s.headers.Authorization
import org.http4s.{AuthScheme, Credentials, Header}

package object headers:
  extension (token: Token)
    def toHeader: Header.ToRaw = token match
      case Token.BearerAuth(token) => Authorization(Credentials.Token(AuthScheme.Bearer, token))
  end extension
end headers
