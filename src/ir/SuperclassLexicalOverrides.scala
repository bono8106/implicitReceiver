package ir

/**
 * A test to see if the lexically bound method call is virtual,
 * so its behavior can be changesd in an outer class' subclass.
 *
 * Newspeak works the same.
 */
object SuperclassLexicalOverrides extends App {

  class OuterSuper {

    def conflicting = "super outer"

    class InnerSuper {

      def test = conflicting

    }

  }

  class Outer extends OuterSuper {

    override def conflicting = "overriden"

    class Inner extends InnerSuper {

    }

  }

  val outer = new Outer

  val inner = new outer.Inner

  println(inner.test) // prints "overriden"

}