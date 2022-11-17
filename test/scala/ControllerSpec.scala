package de.htwg
package controller

import scala.collection.mutable
import model.Field
import model.Stone
import org.scalatest.matchers.should.Matchers._
import org.scalatest.wordspec.AnyWordSpec
import util.Observer

class ControllerSpec extends AnyWordSpec {
  "The Controller" should {
    val controller = Controller(new Field(7, inputMap: mutable.Map[String, String]))
    "change stone from the field when a move is made" in {

    }
    "notify its observers on change" in {
      class TestObserver(controller: Controller) extends Observer:
        controller.add(this)
        var bing = false
        def update = bing = true
      val testObserver = TestObserver(controller)
      testObserver.bing should be(false)
      controller.doAndPublish(controller.put, Move(Stone.X, 1, 2))
      testObserver.bing should be(true)
    }
  }
}