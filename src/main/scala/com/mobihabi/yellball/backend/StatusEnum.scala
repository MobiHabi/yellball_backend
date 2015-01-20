package com.mobihabi.yellball.backend

/**
 * Created by Max Malakhov on 12/25/14.
 */
object StatusEnum extends Enumeration with StatusEnum {
  type Status = Value

  val NotStarted = Value("n/a")
  val Pending = Value("pending")
  val Complete = Value("complete")
  val Rejected = Value("rejected")

  def isFinished(status: Status): Boolean =
    status == Complete || status == Rejected

  def isInProgress(status: Status): Boolean =
    status match {
      case Pending              => true
      case Complete | Rejected  => false
    }
}

trait StatusEnum {

}