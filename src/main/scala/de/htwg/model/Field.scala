package de.htwg.model

import de.htwg.controller.Controller
import de.htwg.model.Stone

class Field(size: Int):

  override def toString() = createField()
  
  def createField(): String =
        print(caption(size))
        print(printXNumbers(size))
        var field: String = ""
        for (y <- 1 to size) {
            field = field + "    " + horizontal(size) + "\n"
            for (x <- 1 to size) {
                if x == 1 then
                    field = field + " 0" + y + " " + vertical() 
                else 
                    field = field + vertical()
                
                field = Controller.koordinaten(x.toString + y.toString)
                }
            field = field + vertical() + "\n"
        }
        field = field + "    " + horizontal(size) + "\n\n"
        field

  //def put(stone: Stone, x: Int, y: Int) = copy(matrix.replaceCell(x, y, stone))

  def horizontal(sizeInput: Int): String = "+----" * sizeInput + "+"

  def vertical(): String = "|"

  def caption(sizeInput: Int): String =
      val space = (sizeInput * 5 / 2)
      if (space <= 0)
          "\nCandyCrush\n\n"
      else
          "\n" + (" " * space) +  "CandyCrush" + "\n\n"

  def printXNumbers(sizeInput: Int): String =
      var xNum = ""
      for (x <- 1 to sizeInput) {
          if x == 1 then
              xNum = xNum + "    " + "  0" + x + " "
          else
              xNum = xNum + "  0" + x + " "
      }
      xNum + "\n"
