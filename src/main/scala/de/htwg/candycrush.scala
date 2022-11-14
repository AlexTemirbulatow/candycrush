package de.htwg

import controller.Controller
import aview.TUI
import model.Field
import model.HashMap

    @main def main(): Unit =
        println("\nHerzlich Willkommen bei CandyCrush!\n")
        val size = 5
        val field = Field(size)
        val controller = Controller(field)
        val tui = TUI(controller)
        //val size = tui.askSize()
        //controller.randomizeStones(size)
        tui.start(size)
