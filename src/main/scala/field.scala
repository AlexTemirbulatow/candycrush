import scala.util.Random

object playfield {
    def main(args: Array[String]): Unit = {
        val size = 3
        print(caption(size))
        for (_ <- 1 to size) {
            print(horizontal(size) + "\n")
            print(symbole(size) + "\n")
        }
        print(horizontal(size) + "\n\n")
    }
    def symbole(sizeInput: Int): String = {
        for (_ <- 1 to sizeInput) {
            val random = Random.between(0, 3)
            random match {
                case 0  => print(printHash())
                case 1  => print(printoo())
                case 2  => print(printzz())
            }
        }
        "|"
    }
    def horizontal(sizeInput: Int): String = "+----" * sizeInput + "+"
    def printHash(): String = "| " + "## "
    def printoo(): String = "| " + "oo "
    def printzz(): String = "| " + "zz "
    def caption(sizeInput: Int): String = {
        val space = (sizeInput * 5 / 2) - 5
            if (space <= 0)
                return "\nCandyCrush\n\n"
        "\n" + (" " * space) +  "CandyCrush\n\n"
    }
}
