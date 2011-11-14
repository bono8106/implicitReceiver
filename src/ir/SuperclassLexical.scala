package ir

object SuperclassLexical extends App {
  
  class OuterSuper {
    
    def conflicting = "super outer" 
      
    class InnerSuper {
      
      // Empty class
      
    }
    
  }
  
  class Outer extends OuterSuper {
    
	  class Inner extends InnerSuper {
		  
		  def test = conflicting
				  
	  }
    
  }
  
  val outer = new Outer
  
  class InnerOutside extends outer.Inner {
    
    override def test = "inner2" // conflicting not accessible here
    
  }

  val inner = new outer.Inner
  
  println(inner.test)
  
}