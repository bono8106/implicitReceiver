package ir

/**
 * This would fail in Newspeak, because private access control is per-object.
 * 
 * @author Nikolay
 *
 */
object AccessControl extends App {

  class X(private val y: Int) {

    def doit(o: X = this) = o.y

  }
  
  // This would work in Newspeak
  println(new X(1).doit())

  // This would fail in Newspeak
  println(new X(1).doit(new X(2)))

}