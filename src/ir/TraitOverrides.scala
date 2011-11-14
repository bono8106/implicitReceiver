package ir

object TraitOverrides extends App {

  class Outer {
    
    def conflicting = "outer class"
    
    class Inner {
      
      def test = conflicting
      
    }
    
  }

  trait Mixin {
    
    def conflicting = "mixin trait"
    
  }
  
  val outer = new Outer
  val nested = new outer.Inner with Mixin
  val nestedAlone = new outer.Inner
  
  println(nested.test)
  
  println(nestedAlone.test)
  
}