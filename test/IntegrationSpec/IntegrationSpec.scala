package IntegrationSpec
//
//import org.junit.runner._
//import org.scalatestplus.junit.JUnitRunner
//import play.api.test._
//import play.api.test.Helpers._
//import play.test.WithBrowser
//
///**
// * add your integration spec here.
// * An integration test will fire up a whole play application in a real (or headless) browser
// */
//@RunWith(classOf[JUnitRunner])
//class IntegrationSpec extends PlaySpecification{
//
//  "Application" should {
//
//    "work from within a browser" in new WithBrowser {
//
//      browser.goTo("http://localhost:" + port)
//
//      browser.pageSource must contain("Your new application is ready.")
//    }
//  }
//}
//


import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner
import play.api.libs.ws._
import play.api.test._
import play.test.WithServer
@RunWith(classOf[JUnitRunner])
class ApplicationIntegrationSpec extends PlaySpecification {

  "Application" should {
    "be reachable" in new WithServer {
      val response = await(WS.url("http://localhost:" + port).get()) //1

      response.status must equalTo(OK) //2
      response.body must contain("Your new application is ready.") //3
    }
  }

}