package ir

/**
 * A test to see if
 * 1) the lexical scope of the outer class' superclass is accessible;
 * 2) the lexical scope of the superclass' outer class is accessible.
 */
object SuperclassLexical extends App {

  class OuterSuper {

    def conflicting = "super outer"

    class InnerSuper

  }

  class Outer extends OuterSuper {

    /**
     * The lexical scope of the outer class' superclass is accessible.
     */
    class Inner extends InnerSuper {

      def test = conflicting // binds to superclass of outer class

    }

  }

  val outer = new Outer

  /**
   * The lexical scope of the superclass' outer class is not accessible here.
   */
  class InnerOutside extends outer.Inner {

    override def test = "inner2" // the conflicting method is not accessible here

  }

  val inner = new outer.Inner

  println(inner.test) // prints "super outer"

}