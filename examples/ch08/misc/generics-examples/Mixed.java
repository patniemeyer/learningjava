import java.util.*;

/**
	
	@author Pat Niemeyer (pat@pat.net)
*/
public class Mixed
{
	public static void main( String [] args )
	{
		Map m = new HashMap();
		Map m2 = new HashMap<String,String>();
		Map<String,String> ms = new HashMap<String,String>();

		//unchecked warning
		// why? obviously compiler knows the var type and can enforce, but it
		// can't guarantee safety of unchecked map assigned to it...
		//Map<String,String> ms2 = new HashMap();
	}

	private static void print( Object o ) { System.out.println(o); }
	private static void print( long o ) { System.out.println(o); }
	private static void print( double o ) { System.out.println(o); }
	private static long time() { return System.currentTimeMillis(); }
}
