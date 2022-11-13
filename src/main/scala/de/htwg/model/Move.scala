package de.htwg.model

import scala.io.StdIn.readLine

final case class Move():

    def moveValid(moveFrom: String, moveTo: String, size: Int): Boolean = //11 21
        val fromX = moveFrom.charAt(0).asDigit // dann 1
        val fromY = moveFrom.charAt(1).asDigit // dann 1
        val toX = moveTo.charAt(0).asDigit     // dann 2
        val toY = moveTo.charAt(1).asDigit     // dann 1
        var valid = false
        
        if fromX == toX && fromY == toY then
            valid = false
        else if (fromX > 1 && fromY > 1) && (fromX < size && fromY < size) then                                 // nicht am Rand
            if (toX == fromX + 1 || toX == fromX - 1) && toY == fromY then                                      // links oder rechts
                valid = true
            else if (toY == fromY + 1 || toY == fromY - 1) && toX == fromX then                                 // oben oder unten
                valid = true
            else
                valid = false
        else if fromX == 1 then                                                                                 // linker Rand
            if toX == fromX + 1 && toY == fromY then                                                            // rechts
                valid = true
            else if ((toY == fromY + 1 && toY <= size) || (toY == fromY - 1 && toY >= 1)) && toX == fromX then  // oben oder unten
                valid = true
            else
                valid = false
        else if fromX == size then                                                                              // rechter Rand
            if toX == fromX - 1 && toY == fromY then                                                            // links
                valid = true
            else if ((toY == fromY + 1 && toY <= size) || (toY == fromY - 1 && toY >= 1)) && toX == fromX then  // oben oder unten
                valid = true
            else 
                valid = false
        else if fromY == 1 then                                                                                 // obere Rand
            if toY == fromY + 1 && toX == fromX then                                                            // unten
                valid = true
            else if ((toX == fromX + 1 && toX <= size) || (toX == fromX - 1 && toX >= 1)) && toY == fromY then  // links oder rechts
                valid = true
            else 
                valid = false
        else if fromY == size then                                                                              // unterer Rand
            if toY == fromY - 1 && toX == fromX then                                                            // oben
                valid = true
            else if ((toX == fromX + 1 && toX <= size) || (toX == fromX - 1 && toX >= 1)) && toY == fromY then  // links oder rechts
                valid = true
            else 
                valid = false
        else
            valid = false
        valid
