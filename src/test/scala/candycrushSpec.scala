import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._

class candycrushSpec extends AnyWordSpec {

    "CandyCrush" should {
        "have a horizontal String of form '+----+'" in {
            horizontal() should be("+----+")
        }

        "have a scalable bar" in {
            horizontal(2) should be("+----+----+")
            horizontal(3) should be("+----+----+----+")
            horizontal(4) should be("+----+----+----+----+")
        }

        "have a String of form '| " + "uu '" in {
            printuu() should be("| " + "uu ")
        }

        "have a String of form '| " + "oo '" in {
            printoo() should be("| " + "oo ")
        }

        "have a String of form '| " + "zz '" in {
            printzz() should be("| " + "zz ")
        }

    }

}
