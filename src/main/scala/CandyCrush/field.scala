import scala.util.Random
import scala.io.StdIn.readInt
import scala.io.StdIn.readLine
import scala.collection.mutable.Map

object field {

    val koordinaten:Map[String, String] = Map()

    def main(args: Array[String]): Unit = {
        println("\nHerzlich Willkommen bei CandyCrush!\n")
        val size = askSize()
        print(createFirstPlayfield(size))
        createGame(size)
    }

    def createGame(size: Int): String =
        var bool = true
        while (bool) {
            print(createNextPlayfield(size))
            bool = askExit()
        }
        "abbrechen"

    def horizontal(sizeInput: Int): String = "+----" * sizeInput + "+"
    def vertical(): String = "|"
    def printuu(): String = Console.BLUE + " uu " + Console.WHITE
    def printoo(): String = Console.MAGENTA + " oo " + Console.WHITE
    def printzz(): String = Console.GREEN + " zz " + Console.WHITE

    def caption(sizeInput: Int): String =
        val space = (sizeInput * 5 / 2)
            if (space <= 0)
                return "\nCandyCrush\n\n"
        "\n" + (" " * space) +  "CandyCrush" + "\n\n"

    def askSize(): Int =
        print("Bitte gebe eine Feldgröße an: ")
        val size = readInt()
        size

    def askExit(): Boolean =
        print("abbrechen = 0\nnochmal = 1\n")
        val input = readInt()
        print("\n")
        if input == 0 then
            false
        else
            true

    def moveFrom(): String =
        println("Koordinaten x und y eingeben (ohne führende 0).\n")
        println("Was soll getauscht werden?")
        print("x: ")
        val x = readLine()
        print("y: ")
        val y = readLine()
        x + y

    def moveTo(): String =
        println("Wohin soll getauscht werden? (eine Position nach oben/unten/rechts/links)")
        print("x: ")
        val x = readLine()
        print("y: ")
        val y = readLine()
        var moveTo = x + y
        moveTo

    def printXNumbers(size: Int): String =
        for (x <- 1 to size) {
            if x == 1 then
                print("    " + "  0" + x + " ")
            else
                print("  0" + x + " ")
        }
        "\n"

    def symboleRandomizer(field: String, x: Int, y: Int): String =
        var inputField = field
        val random = Random.between(0, 3)
        random match {
            case 0  => {
                inputField = inputField + printuu()
                var koord = x.toString() + y.toString()
                koordinaten += (koord -> printuu())
            }
            case 1  => {
                inputField = inputField + printoo()
                var koord = x.toString() + y.toString()
                koordinaten += (koord -> printoo())
            }
            case 2  => {
                inputField = inputField + printzz()
                var koord = x.toString() + y.toString()
                koordinaten += (koord -> printzz())
            }
        }
        inputField

    def createFirstPlayfield(size: Int): String =
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

                field = symboleRandomizer(field, x, y)
            }
            field = field + vertical() + "\n"
        }
        field = field + "    " + horizontal(size) + "\n\n"
        field

    def createNextPlayfield(size: Int): String =
        val moveFromPos = moveFrom()              // wenn 21
        val moveToPos = moveTo()                  // wenn 31
        val fromX = moveFromPos.charAt(0).asDigit // dann 2
        val fromY = moveFromPos.charAt(1).asDigit // dann 1
        val toX = moveToPos.charAt(0).asDigit     // dann 3
        val toY = moveToPos.charAt(1).asDigit     // dann 1
        var help = ""

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
        field
}
