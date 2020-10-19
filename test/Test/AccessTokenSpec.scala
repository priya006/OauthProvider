package Test

import java.util.Date

import models.OauthAccessToken
import org.scalatest.FlatSpec
import scalaoauth2.provider.AccessToken
import org.scalatest.Matchers._

class AccessTokenSpec  extends FlatSpec{

  it should "say a token is active that is not yet expired" in {
    val token = AccessToken(
      "token",
      None,
      None,
      lifeSeconds = Some(15),
      createdAt = new Date()
    )
    token.isExpired shouldBe false
  }


  it should "Oauth Access Token is not empty" in {
    val oauthTable = OauthAccessToken.tableName
    oauthTable nonEmpty
  }

}
