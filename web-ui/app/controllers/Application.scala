package controllers


import javax.inject.Inject

import org.webjars.RequireJS
import play.api._
import play.api.mvc._

class Application @Inject()(implicit webJarAssets: WebJarAssets) extends Controller with XhrActionSupport {

  def index = indexWithPath("/")

  def indexWithPath(path: String) = Action {
    Ok(views.html.main(webJarAssets, "play-scala-angularjs-gulp"))
  }

}
