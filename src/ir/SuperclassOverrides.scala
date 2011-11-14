package ir

/**
 * A method is defined both in a superclass and in the enclosing lexical scope (an outer class).
 * 
 * Newspeaks picks the Outer class implementation, in contrast to Scala, which picks
 * the super class.
 * 
 * @author Nikolay
 *
 */
object SuperclassOverrides extends App {

  class InnerSuper {
    
    def conflicting = "inner superclass"
    
  }
  
  class Outer {
    
    def conflicting = "outer class"
    
    class Inner extends InnerSuper {
      
      def test = conflicting
      
    }
    
  }
  
  val outer = new Outer
  val inner = new outer.Inner
  println(inner.test)

}