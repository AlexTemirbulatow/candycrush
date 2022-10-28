import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._

class candycrushSpec extends AnyWordSpec {

    "CandyCrush" should {
        
        "have a horizontal String of form '+----+'" in {
            field.horizontal(1) should be("+----+")
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

        "have a String of form '|'" in {
            field.symbole(1) should be("|")
            field.symbole(2) should be("|")
            field.symbole(3) should be("|")
        }

        "have a String of form 'CandyCrush'" in {
            field.caption(1) should be("CandyCrush")
            field.caption(2) should be("CandyCrush")
        }

        "have a String of form ' CandyCrush'" in {
            field.caption(3) should be("  CandyCrush")
            field.caption(4) should be("     CandyCrush")
        }

    }

}
