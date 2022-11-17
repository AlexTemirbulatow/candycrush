package de.htwg.model

import scala.collection.mutable
import scala.collection.mutable.Map
import scala.util.Random

class HashMap(size: Int):
    
    def randomizeStones(): mutable.Map[String, String] =
        val koordinaten: mutable.Map[String, String] = mutable.Map()
        for (y <- 1 to size) {
            for (x <- 1 to size) {
                Random.between(0, 3) match
                    case 0  => koordinaten += (x.toString + y.toString -> Stone().printuu())
                    case 1  => koordinaten += (x.toString + y.toString -> Stone().printoo())
                    case 2  => koordinaten += (x.toString + y.toString -> Stone().printzz())
            }
        }
        koordinaten

    // def Check for randomizer(not randomize combination)
    // def Check if no combinations -> randomize again
