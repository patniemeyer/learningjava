//file: Invoke.java
import java.lang.reflect.*;

class Invoke {
  public static void main( String [] args ) {
    try {
      Class c = Class.forName( args[0] );
      Method m = c.getMethod( args[1] );
      Object ret =  m.invoke( null );
      System.out.println(
          "Invoked static method: " + args[1]
          + " of class: " + args[0]
          + " with no args\nResults: " + ret );
    } catch ( ClassNotFoundException e ) {
		System.out.println( e );
      // Class.forName(  ) can't find the class
    } catch ( NoSuchMethodException e2 ) {
		System.out.println( e2 );
      // that method doesn't exist
    } catch ( IllegalAccessException e3 ) {
		System.out.println( e3 );
      // we don't have permission to invoke that method
    } catch ( InvocationTargetException e ) {
		System.out.println( e );
      // an exception ocurred while invoking that method
      System.out.println(
          "Method threw an: " + e.getTargetException(  ) );
    }
  }
}
