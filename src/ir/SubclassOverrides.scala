package ir

/**
 * A subclass defines a method that is called from the superclass,
 * but bound to the enclosing scope.
 *
 * Newspeak works the same.
 *
 * @author Nikolay
 *
 */
object SubclassOverrides extends App {

  class Outer {

    def conflicting = "outer class"

    class Inner {

      def test = conflicting // binds to outer class, even in subclasses

    }

  }

  val outer = new Outer

  class InnerSubclass extends outer.Inner {
    def conflicting = "inner subclass"
  }

  val inner = new InnerSubclass

  println(inner.test) // prints "outer class"

}