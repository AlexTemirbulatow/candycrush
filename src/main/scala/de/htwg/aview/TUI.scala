package de.htwg
package aview

import scala.io.StdIn.readLine
import scala.io.StdIn.readInt
import scala.util.matching.Regex

import util.Observer

import de.htwg.controller.Controller
import de.htwg.model.Field
import de.htwg.model.Move
import de.htwg.model.Stone


class TUI(controller: Controller) extends Observer:

    val checkSize: Regex = "[4-9]".r

    def start(size: Int) =
        print(controller.field.toString)
        gameLoop(size)
    
    def gameLoop(size: Int): Unit =
        while (!controller.checkMove(moveFrom(size), moveTo(size)))
            println("\nUngültiger Zug, bitte erneut eingeben.\n")
            gameLoop(size)
        print(controller.field.toString)
        askExit()
        gameLoop(size)

    def askSize(): Int = 
        print("Bitte gebe eine Feldgröße an (zwischen 4 - 9): ")
        val size = readLine() // 4 - 9
        while (!checkSize.matches(size)) {
            println("\nUngültige Eingabe\n")
            askSize()
        }
        size.toInt

    def askExit(): Boolean =
        println("abbrechen = 0\nnochmal = 1\n")
        val bool = true
        val input = readLine()
        input match
            case "0"     => System.exit(0)            
            case "1"     =>
            case _       => println("\nUngültige Eingabe\n")
                            askExit()
        bool

    def moveFrom(size: Int): String =
        println("Koordinaten x und y eingeben (ohne führende 0).\n")
        println("Was soll getauscht werden?")
        print("x: ")
        val x = readLine()
        print("y: ")
        val y = readLine()
        while (x.toInt < 1 || x.toInt > size || y.toInt < 1 || y.toInt > size)
            println("\nUngültige Eingabe, bitte erneut eingeben.\n")
            moveFrom(size)
        x + y

    def moveTo(size: Int): String =
        println("Wohin soll getauscht werden? (eine Position nach oben/unten/rechts/links)")
        print("x: ")
        val x = readLine()
        print("y: ")
        val y = readLine()
        while (x.toInt < 1 || x.toInt > size || y.toInt < 1 || y.toInt > size)
            println("\nUngültige Eingabe, bitte erneut eingeben.\n")
            moveTo(size)
        x + y
