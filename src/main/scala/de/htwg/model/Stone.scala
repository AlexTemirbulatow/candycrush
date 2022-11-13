package de.htwg.model

class Stone():

  def printuu(): String = Console.BLUE + " uu " + Console.WHITE
  def printzz(): String = Console.GREEN + " zz " + Console.WHITE 
  def printoo(): String = Console.MAGENTA + " oo " + Console.WHITE 
 

/*enum Stone(randomNumber: String):
    override def toString = randomNumber
    case uu extends Stone("  uu  ")
    case oo extends Stone("  oo  ")
    case zz extends Stone("  zz  ") */

/*    def symboleRandomizer(field: String, x: Int, y: Int): String =
        var inputField = field
        val random = Random.between(0, 3)
        random match {
            case 0  => {
                inputField = inputField + printuu()
                var koord = x.toString + y.toString
                controller.koordinaten += (koord -> printuu())
            }
            case 1  => {
                inputField = inputField + printoo()
                var koord = x.toString + y.toString
                controller.koordinaten += (koord -> printoo())
            }
            case 2  => {
                inputField = inputField + printzz()
                var koord = x.toString + y.toString
                controller.koordinaten += (koord -> printzz())
            }
        }
        inputField

    def printuu(): String = Console.BLUE + " uu " + Console.WHITE
    def printoo(): String = Console.MAGENTA + " oo " + Console.WHITE 
    def printzz(): String = Console.GREEN + " zz " + Console.WHITE */
