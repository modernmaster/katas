import org.openqa.selenium.phantomjs.{PhantomJSDriver, PhantomJSDriverService}
import org.specs2.execute.{AsResult, Result}
import org.specs2.mutable.Around
import org.specs2.specification.Scope
import play.api.test.Helpers._
import play.api.test.TestBrowser

abstract class WithPhantomJS() extends Around with Scope {

  implicit def app = FakeApplication()

  implicit def port = play.api.test.Helpers.testServerPort

  lazy val browser: TestBrowser = {
    val defaultCapabilities = DesiredCapabilities.phantomjs
    val additionalCapabilities = new DesiredCapabilities()
    val capabilities = new DesiredCapabilities(defaultCapabilities, additionalCapabilities)

    capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "../../node_modules/phantomjs/lib/phantom/bin/phantomjs.exe")
    val driver = new PhantomJSDriver(capabilities)
    TestBrowser(driver, Some("http://localhost:" + port))
  }

  override def around[T: AsResult](body: => T): Result = {
    //    try {
    running(TestServer(port, app))(AsResult.effectively(body))
    //    } finally {
    //      browser.quit()
    //    }
  }
}