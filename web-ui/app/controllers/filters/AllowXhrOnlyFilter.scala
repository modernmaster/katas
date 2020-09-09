package controllers.filters

import controllers.{RequestWithAttributes, StackableFilter}
import play.api.mvc.{Result, Results}

import scala.concurrent.Future

/**
 * XMLHttpRequest
 */
trait AllowXhrOnlyFilter extends StackableFilter with Results {

  abstract override def filter[A](request: RequestWithAttributes[A])(f: (RequestWithAttributes[A]) => Future[Result]): Future[Result] = {
    if (isAjaxRequest(request)) {
      super.filter(request)(f)
    } else {
      resultIfNotXhrRequest(request)
    }
  }

  def resultIfNotXhrRequest[A](request: RequestWithAttributes[A]): Future[Result] = {
    Future.successful(BadRequest("Not XMLHttpRequest !!"))
  }

  def isAjaxRequest(request: RequestWithAttributes[_]): Boolean = {
    request.headers.get(headerName).isDefined
  }

  private def headerName: String = "X-Requested-With"

}
