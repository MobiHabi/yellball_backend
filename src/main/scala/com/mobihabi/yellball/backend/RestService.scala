package com.mobihabi.yellball.backend

/**
 * Created by Max Malakhov on 11/21/14.
 */
import akka.actor.Actor
import spray.routing._
import spray.http._
import MediaTypes._

// we don't implement our route structure directly in the service actor because
// we want to be able to test it independently, without having to spin up an actor
class RestServiceActor extends Actor with RestService {

  // the HttpService trait defines only one abstract member, which
  // connects the services environment to the enclosing actor or test
  def actorRefFactory = context

  // this actor only runs our route, but you could add
  // other things here, like request stream processing
  // or timeout handling
  def receive = runRoute(myRoute)
}


// this trait defines our service behavior independently from the service actor
trait RestService extends HttpService {

  val tuple = ("sdfds",12312, Console)
//  val status = StatusEnum.Complete

//  println(StatusEnum.isFinished(status))
  println("Hi from console")

  val myRoute =
    path("test") {
      get {
        respondWithMediaType(`text/html`) { // XML is marshalled to `text/xml` by default, so we simply override here
          complete {
            <html>
              <body>
                <h1>Say hello to <i>spray-routing</i> on <i>spray-can</i>MAX!</h1>
              </body>
            </html>
          }
        }
      }
    }
}