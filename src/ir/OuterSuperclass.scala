package ir

/**
 * A method call from an inner class A is automatically bound to the superclass of A's outer class.
 * 
 * Newspeak does not work.
 */
object OuterSuperclass extends App {
  
  class OuterSuper {
    
    def conflicting = "outer superclass"
    
  }
  
  class Outer extends OuterSuper {
    
    class Inner {
      
      def test = conflicting
      
    }
    
  }

  val outer = new Outer
  val inner = new outer.Inner
		  
  println(inner.test)
  
}