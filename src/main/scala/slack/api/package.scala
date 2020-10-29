package slack

import cats.Id
import play.api.libs.json.{Format, JsValue}

import scala.concurrent.{ExecutionContext, Future}

package object api {
  type BlockingSlackApiClient = SlackApiClientF[Id] //only for backward compatibility

  implicit class ExtractHelper(val jsFuture: Future[JsValue]) extends AnyVal {
    def extract[T](field: String)(implicit ec: ExecutionContext, fmt: Format[T]): Future[T] = {
      jsFuture.map(js => (js \ field).as[T])
    }
  }
}