package ir

/**
 * A method call from an inner class is explicitly bound to the outer class.
 * 
 * Newspeak status: not possible.
 */
object OuterExplicit extends App {
  
  class Outer {
    
    def conflicting = "outer"
    
    class Inner {
      
      def conflicting = "inner"
      
      def test = Outer.this.conflicting
      
    }
    
  }
  
  val outer = new Outer
  val inner = new outer.Inner
  
  println(inner.test)

}