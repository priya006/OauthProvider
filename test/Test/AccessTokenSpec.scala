//package Test
//
//import java.util.Date
//
//import models.OauthAccessToken
//import org.scalatest.FlatSpec
//import scalaoauth2.provider.AccessToken
//import org.scalatest.Matchers._
//import scalikejdbc.DBSession
//import play.api.libs.json._
//import play.api.mvc._
//import play.api.routing.sird._
//import play.api.test.FakeRequest
//import play.core.server.Server
//import play.mvc.Http
//import play.mvc.Http.RequestBuilder
//import play.test.{Helpers, WithApplication}
//
//
//class AccessTokenSpec  extends FlatSpec{
//
//  it should "say a token is active that is not yet expired" in {
//    val token = AccessToken(
//      "token",
//      None,
//      None,
//      lifeSeconds = Some(15),
//      createdAt = new Date()
//    )
//    token.isExpired shouldBe false
//  }
//
//
//  it should "Oauth Access Token is not empty" in {
//    val oauthTable = OauthAccessToken.tableName
//    oauthTable nonEmpty
//  }
//
//
//  it should "Oauth Access Token is not empty" in {
//    val oauthTable = OauthAccessToken.findByAccessToken("sdsdsd")(DBSession)
//    oauthTable nonEmpty
//  }
//
//
//  "respond to the index Action" in new WithApplication(applicationWithRouter) {
//    val Some(result) = route(app, FakeRequest(GET, "/Bob"))
//
//    status(result) must equalTo(OK)
//    contentType(result) must beSome("text/html")
//    charset(result) must beSome("utf-8")
//    contentAsString(result) must contain("Hello Bob")
//  }
//  }
