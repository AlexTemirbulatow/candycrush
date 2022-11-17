package de.htwg
package aview

import de.htwg.controller.Controller
import de.htwg.model.Field
import util.Observer

import scala.io.StdIn.readLine
import scala.io.StdIn.readInt

class TUI(controller: Controller, size: Int) /*extends Observer*/:

    def start(): Unit =
        print(controller.field.toString())
        gameLoop()

    def gameLoop(): Unit =
        while (!controller.doMove(moveFrom(), moveTo()))
            println(Console.RED + "\nUngültiger Zug, bitte erneut eingeben.\n" + Console.WHITE)
            gameLoop()
        print(controller.field.toString())
        askExit()
        gameLoop()
    

    
    def moveFrom(): String =
        println("Koordinaten x und y eingeben (ohne führende 0).\n")
        println("Was soll getauscht werden?")
        print("x: ")
        val x = readLine()
        print("y: ")
        val y = readLine()
        while (x.toInt < 1 || x.toInt > size || y.toInt < 1 || y.toInt > size)
            println(Console.RED + "\nUngültige Eingabe, bitte erneut eingeben.\n" + Console.WHITE)
            gameLoop()
        x + y

    def moveTo(): String =
        println("Wohin soll getauscht werden? (eine Position nach oben/unten/rechts/links)")
        print("x: ")
        val x = readLine()
        print("y: ")
        val y = readLine()
        while (x.toInt < 1 || x.toInt > size || y.toInt < 1 || y.toInt > size)
            println(Console.RED + "\nUngültige Eingabe, bitte erneut eingeben.\n" + Console.WHITE)
            gameLoop()
        x + y

    def askExit(): Boolean =
        println("abbrechen = 0\nnochmal = 1")
        readLine() match
            case "0"     => System.exit(0)
            case "1"     =>
            case _       => println(Console.RED + "\nUngültige Eingabe\n" + Console.WHITE)
                            askExit()
        true

    /*val checkSize: Regex = "[4-9]".r
    
    def askSize(): Int =
    print("Bitte gebe eine Feldgröße an (zwischen 4 - 9): ")
    val size = readLine() // 4 - 9
    while (!checkSize.matches(size)) {
        println(Console.RED + "\nUngültige Eingabe\n" + Console.WHITE)
        askSize()
    }
    size.toInt */
