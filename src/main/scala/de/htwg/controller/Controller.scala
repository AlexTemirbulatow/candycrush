package de.htwg
package controller

import de.htwg.model.Field
import de.htwg.util.Observable

import scala.collection.mutable

case class Controller(var field: Field, var hashMap: mutable.Map[String, String]) extends Observable:
  
  def doMove(moveFromPos: String, moveToPos: String): Boolean =
    field.doMove(moveFromPos, moveToPos)
    //notifyObservers
