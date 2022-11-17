package de.htwg
package aview
package model

import scala.collection.mutable
import controller.Controller
import model.Field
import model.Move
import model.Stone
import model.HashMap
import org.scalatest.matchers.should.Matchers._
import org.scalatest.wordspec.AnyWordSpec
import de.htwg.model.Field

class TuiSpec extends AnyWordSpec {

  "The TUI" should {
    val tui = TUI(Controller(new Field(7, inputMap: mutable.Map[String, String])))
    "recognize the input x = 1 and y = 1 and x =1 and y = 2 as move of stone from (1,1) to (1,2)" in {
        tui.analyseInput(1,1,1,2) should be (Some(HashMap(stone,1,1,1,2)))

    }
  }
}