
import java.util.*;
/**
	
	@author Pat Niemeyer (pat@pat.net)
*/
public class ClassTest 
{
	public static void main( String [] args )
	{
		Class<String> cs = String.class;
		// error
		//Class<String> cs2 = Integer.class;
		Map<String,String> ms;
	}

	private static void print( Object o ) { System.out.println(o); }
	private static void print( long o ) { System.out.println(o); }
	private static void print( double o ) { System.out.println(o); }
	private static long time() { return System.currentTimeMillis(); }
}
