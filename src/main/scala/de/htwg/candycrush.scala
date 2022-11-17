package de.htwg

import aview.TUI
import controller.Controller
import model.Field
import model.HashMap
import model.Stone

    @main def main(): Unit =
        println(Console.WHITE + "\n    Herzlich Willkommen bei CandyCrush!\n")
        val size = 7
        val hashMap = HashMap(size).randomizeStones()
        val field = Field(size, hashMap)
        val controller = Controller(field, hashMap)
        val tui = TUI(controller, size)
        tui.start()
