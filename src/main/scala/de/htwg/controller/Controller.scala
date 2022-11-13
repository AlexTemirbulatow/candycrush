package de.htwg
package controller

import de.htwg.model.Field
import de.htwg.model.Stone
import de.htwg.util.Observable

import scala.collection.mutable.Map
import scala.util.Random

case class Controller(var field: Field) extends Observable:

  val koordinaten:Map[String, String] = Map()

  def checkMove(moveFromPos: String, moveToPos: String): Boolean =
    val fromX = moveFromPos.charAt(0).asDigit
    val fromY = moveFromPos.charAt(1).asDigit
    val toX = moveToPos.charAt(0).asDigit    
    val toY = moveToPos.charAt(1).asDigit    
    var valid: Boolean = false
                            
    if (toX == fromX + 1 || toX == fromX - 1) && toY == fromY then       // links, rechts                             
        valid = true
    else if (toY == fromY + 1 || toY == fromY - 1) && toX == fromX then  // oben, unten
        valid = true
    else
        valid = false
    if valid == true then doMove(fromX: Int, fromY: Int, toX: Int, toY: Int, moveFromPos: String, moveToPos: String)
    valid

  def doMove(fromX: Int, fromY: Int, toX: Int, toY: Int, moveFromPos: String, moveToPos: String): Unit =
    var help = ""
    if !(toY < fromY || toX < fromX) then                                // rechts, unten
        help = koordinaten(moveFromPos)
        koordinaten(moveFromPos) = koordinaten(moveToPos)
        koordinaten(moveToPos) = help
    else if toY < fromY || toX < fromX then                              // links, oben
        help = koordinaten(moveToPos)
        koordinaten(moveToPos) = koordinaten(moveFromPos)
        koordinaten(moveFromPos) = help
    else println("\nUngültige Eingabe.\n")
    notifyObservers
  
  def randomizeStones(size: Int): Unit =
     for (y <- 1 to size) {
        for (x <- 1 to size) {
            val random = Random.between(0, 3)
            random match
                case 0  =>  koordinaten += (x.toString + y.toString -> Stone.printuu())
                case 1  =>  koordinaten += (x.toString + y.toString -> Stone.printoo()) 
                case 2  =>  koordinaten += (x.toString + y.toString -> Stone.printzz())
        }
    }
