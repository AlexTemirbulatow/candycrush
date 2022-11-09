import scala.util.Random
import scala.io.StdIn.readInt
import scala.io.StdIn.readLine
import scala.collection.mutable.Map

val koordinaten:Map[String, String] = Map()

object field {
    def main(args: Array[String]): Unit = {
        println("\nHerzlich Willkommen bei CandyCrush!\n")
        val size = askSize()
        val field = createFirstPlayfield(size)
        print(koordinaten)
        createGame(size)
    }

    def horizontal(sizeInput: Int): String = "+----" * sizeInput + "+"
    def vertical(): String = "|"
    def printuu(): String = Console.BLUE + " uu " + Console.WHITE
    def printoo(): String = Console.MAGENTA + " oo " + Console.WHITE 
    def printzz(): String = Console.GREEN + " zz " + Console.WHITE
    def caption(sizeInput: Int): String = 
        val space = (sizeInput * 5 / 2) - 5
            if (space <= 0)
                return "CandyCrush"
        (" " * space) +  "CandyCrush"
    def askSize(): Int = 
        print("Bitte gebe eine Feldgröße an: ")
        val size = readInt()
        if (size < 4 || size > 9)
            println("\nFalsche Eingabe!\n")
            askSize()
        else 
            size
    def moveFrom(): String =
        println("Koordinaten x und y eingeben (ohne führende 0).\n")
        println("Was soll getauscht werden?")
        print("x: ")
        val x = readLine()
        print("y: ")
        val y = readLine()
        x + y
    def moveTo(): String = {
        println("Wohin soll getauscht werden? (eine Position nach oben/unten/rechts/links)")
        print("x: ")
        val x = readLine()
        print("y: ")
        val y = readLine()
        var moveTo = x + y
        moveTo
    }
    def createFirstPlayfield(size: Int): String =
        print("\n" + caption(size) + "\n\n")
        for (x <- 1 to size) { 
            if x == 1 then
                print("    " + "  0" + x + " ") 
            else 
                print("  0" + x + " ")
        }
        print("\n")
        var field: String = ""
        for (y <- 1 to size) {
            field = field + "    " + horizontal(size) + "\n"
            for (x <- 1 to size) {
                if x == 1 then
                    field = field + " 0" + y + " " + vertical() 
                else 
                    field = field + vertical()
                val random = Random.between(0, 3)
                random match {
                    case 0  => { 
                        field = field + printuu()
                        var koord = x.toString() + y.toString()
                        koordinaten += (koord -> printuu())
                    }
                    case 1  => {
                        field = field + printoo()
                        var koord = x.toString() + y.toString()
                        koordinaten += (koord -> printoo())
                    }
                    case 2  => {
                        field = field + printzz()
                        var koord = x.toString() + y.toString()
                        koordinaten += (koord -> printzz())
                    }
                }
            }
            field = field + vertical() + "\n"
        }
        field = field + "    " + horizontal(size) + "\n\n"
        print(field)
        field
    def createGame(size: Int): String =
        var bool = true
        while (bool) {
            createNextPlayfield(size)

            print("abbrechen = 0\nnochmal = 1\n")
            val input = readInt()
            print("\n")
            if input == 0 then
                bool = false
            else 
                bool = true

        }
        "abbrechen"

    def createNextPlayfield(size: Int): String =
        val moveFromPos = moveFrom()
        val moveToPos = moveTo()
        var help = ""
        val fromX = moveFromPos.charAt(0).asDigit // 2
        val fromY = moveFromPos.charAt(1).asDigit // 1
        val toX = moveToPos.charAt(0).asDigit     // 3
        val toY = moveToPos.charAt(1).asDigit     // 1

        print("\n" + caption(size) + "\n\n")
        for (x <- 1 to size) { 
            if x == 1 then
                print("    " + "  0" + x + " ") 
            else 
                print("  0" + x + " ")
        }
        print("\n")

            

        var field: String = ""
        for (y <- 1 to size) {
            field = field + "    " + horizontal(size) + "\n"
            for (x <- 1 to size) {
                if x == 1 then
                    field = field + " 0" + y + " " + vertical() 
                else 
                    field = field + vertical()
                if (fromY == y && fromX == x) && !(toY < fromY || toX < fromX) then
                    field = field + koordinaten(moveToPos)
                    help = koordinaten(moveFromPos)
                    koordinaten(moveFromPos) = koordinaten(moveToPos)
                else if toY == y && toX == x then
                    if toY < fromY || toX < fromX then
                        field = field + koordinaten(moveFromPos)
                        help = koordinaten(moveToPos)
                        koordinaten(moveToPos) = koordinaten(moveFromPos)
                        koordinaten(moveFromPos) = help
                    else 
                        field = field + help
                        koordinaten(moveToPos) = help
                else
                    var koord = x.toString() + y.toString()
                    field = field + koordinaten(koord)
               
            }
            field = field + vertical() + "\n"
        }
        field = field + "    " + horizontal(size) + "\n\n"
        print(field)
        field
}
