//import scala.io.StdIn._
import scala.util.Random

object playfield {

    val size = 10
    def main(args: Array[String]): Unit = {
        
        print(caption(size))
        for (_ <- 1 to size) {
            print(horizontal(size))
            print("\n")
            print(symbole(size))
            print("\n")
        }
        print(horizontal(size))
        println("\n")
    }

    def symbole(a: Int): String = {
            for (_ <- 1 to a) {
                val random = Random.between(0, 3)
                random match {
                    case 0  => print("| " + "## ")
                    case 1  => print("| " + "oo ")
                    case 2  => print("| " + "uu ")
            }
        }
            print("|")
            ""
        //("| " + "## ") * a + "|"
    }

    def horizontal(b: Int): String = {
        "+----" * b + "+"
    }

    def caption(c: Int): String = {
        val space = (size * 5 / 2) - 5
        "\n" + (" " * space) +  "CandyCrush\n\n"
    }
}
