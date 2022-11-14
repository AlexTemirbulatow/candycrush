package de.htwg
package controller

import de.htwg.model.Field
import de.htwg.model.Stone
import de.htwg.model.HashMap
//import de.htwg.util.Observable

import scala.util.Random

case class Controller(var field: Field) /*extends Observable*/:

  def checkMove(moveFromPos: String, moveToPos: String): Boolean =
    val fromX = moveFromPos.charAt(0).asDigit
    val fromY = moveFromPos.charAt(1).asDigit
    val toX = moveToPos.charAt(0).asDigit    
    val toY = moveToPos.charAt(1).asDigit    
    var valid: Boolean = false
                            
    if (toX == fromX + 1 || toX == fromX - 1) && toY == fromY then valid = true      // links, rechts 
    else if (toY == fromY + 1 || toY == fromY - 1) && toX == fromX then valid = true // oben, unten
    else valid = false

    if valid then doMove(fromX: Int, fromY: Int, toX: Int, toY: Int, moveFromPos: String, moveToPos: String)

    valid

  def doMove(fromX: Int, fromY: Int, toX: Int, toY: Int, moveFromPos: String, moveToPos: String): Unit =
    var help = ""
    if !(toY < fromY || toX < fromX) then                                // rechts, unten
        help = HashMap().koordinaten(moveFromPos)
        HashMap().koordinaten(moveFromPos) = HashMap().koordinaten(moveToPos)
        HashMap().koordinaten(moveToPos) = help
    else if toY < fromY || toX < fromX then                              // links, oben
        help = HashMap().koordinaten(moveToPos)
        HashMap().koordinaten(moveToPos) = HashMap().koordinaten(moveFromPos)
        HashMap().koordinaten(moveFromPos) = help
    else println("\nUngültige Eingabe.\n")
