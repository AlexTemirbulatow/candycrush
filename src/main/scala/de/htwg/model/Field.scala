package de.htwg.model

import scala.collection.mutable

class Field(size: Int, hashMap: mutable.Map[String, String]):

  override def toString: String = createField()
  
  def createField(): String =
        print(caption(size))
        print(printxNumbers(size))
        var field: String = ""
        for (y <- 1 to size) {
            field = field + "    " + horizontal(size) + "\n"
            for (x <- 1 to size) {
                if x == 1 then
                    field = field + " 0" + y + " " + vertical() 
                else 
                    field = field + vertical()

                field = field + " " + hashMap(x.toString + y.toString) + " "

                }
            field = field + vertical() + "\n"
        }
        field = field + "    " + horizontal(size) + "\n\n"
        field

  def horizontal(sizeInput: Int): String = "+----" * sizeInput + "+"

  def vertical(): String = "|"

  def caption(sizeInput: Int): String = "\n" + (" " * (sizeInput * 5 / 2)) +  "CandyCrush" + "\n\n"

  def printxNumbers(sizeInput: Int): String =
      val numbers = (1 to sizeInput).toArray
      "      0" + numbers.mkString("   0") + "\n"

  def doMove(moveFromPos: String, moveToPos: String): Boolean =
    val inputMap = hashMap
    val temp = inputMap(moveFromPos)
    val difference = ((moveToPos.charAt(0).asDigit - moveFromPos.charAt(0).asDigit) +
                        (moveToPos.charAt(1).asDigit - moveFromPos.charAt(1).asDigit)).abs
    difference match
      case 1 =>
        hashMap(moveFromPos) = hashMap(moveToPos)
        hashMap(moveToPos) = temp
        true
      case _ => false


// fromX: Int, fromY: Int, toX: Int, toY: Int,
  /*def checkCombinations(): Unit =
  val inputMap = hashMap
  for (y <- 1 to size) {
    for (x <- 1 to size) {

    }
  }*/

