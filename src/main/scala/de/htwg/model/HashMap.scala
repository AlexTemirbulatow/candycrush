package de.htwg.model

import scala.collection.mutable
import scala.collection.mutable.Map
import scala.util.Random

class HashMap:

    val koordinaten: mutable.Map[String, String] = mutable.Map()

    def randomizeStones(size: Int): Unit =
        for (y <- 1 to size) {
            for (x <- 1 to size) {
                val random = Random.between(0, 3)
                random match
                    case 0  => koordinaten += (x.toString + y.toString -> Stone().printuu())
                    case 1  => koordinaten += (x.toString + y.toString -> Stone().printoo())
                    case 2  => koordinaten += (x.toString + y.toString -> Stone().printzz())
            }
        }
        print(koordinaten)
