//package Test
//
//import java.util.Date
//
//import models.{OauthAccessToken, OauthAuthorizationCode}
//import org.scalatest.FlatSpec
//import scalaoauth2.provider.AccessToken
//
//trait AccessTokenSpec1 extends FlatSpec {
//
//  it should "say a token is active that is not yet expired" in {
//    val token = AccessToken(
//      "token",
//      None,
//      None,
//      lifeSeconds = Some(15),
//      createdAt = new Date()
//    )
//   token.isExpired shouldBe false
//  }
//
//
////  it should "say a token is active that" in {
////    val token = OauthAccessToken(
////      12,
////      15,
////      None,
////      21,
////      None,
////      "some",
////      "String",
////      createdAt = new Date()
////    )
//////    token shouldBe false
////  }
//
////
////  it should "say a token is active that" in {
////    val token = OauthAuthorizationCode.findByCode(
////     "String"
////    )
////    //    token shouldBe false
////  }
//
//
//}
