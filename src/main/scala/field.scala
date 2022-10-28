import scala.util.Random

object field {
    def main(args: Array[String]): Unit = {
        val size = 1
        for (_ <- 1 to size) {
            print(horizontal(size) + "\n")
            print(symbole(size) + "\n")
        }
        print(horizontal(size) + "\n")
    }
    def horizontal(sizeInput: Int): String = "+----" * sizeInput + "+"
    def printuu(): String = "| " + "uu "
    def printoo(): String = "| " + "oo "
    def printzz(): String = "| " + "zz "
    def symbole(sizeInput: Int): String = {
        for (_ <- 1 to sizeInput) {
            val random = Random.between(0, 3)
            random match {
                case 0  => print(printuu())
                case 1  => print(printoo())
                case 2  => print(printzz())
            }
        }
        "|"
    }
}
