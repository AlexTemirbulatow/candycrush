import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._

class candycrushSpec extends AnyWordSpec {

    "CandyCrush" should {
        "have a horizontal String of form '+----+'" in {
            field.horizontal() should be("+----+")
        }

        "have a scalable bar" in {
            field.horizontal(2) should be("+----+----+")
            field.horizontal(3) should be("+----+----+----+")
            field.horizontal(4) should be("+----+----+----+----+")
        }

        "have a String of form '| " + "uu '" in {
            field.printuu() should be("| " + "uu ")
        }

        "have a String of form '| " + "oo '" in {
            field.printoo() should be("| " + "oo ")
        }

        "have a String of form '| " + "zz '" in {
            field.printzz() should be("| " + "zz ")
        }

    }

}
