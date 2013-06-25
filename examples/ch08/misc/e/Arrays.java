//package bsh.util;
/** @author Pat Niemeyer (pat@pat.net) */
import java.util.*;

public class Arrays 
{
	public static void main( String [] args )
	{
		// List<?>[] la = new ArrayList<?>[10]; // ok
		// List<?>[] la = new ArrayList<? extends Date>[10]; // err

		//List<? extends Date>[] la = new ArrayList[5];
		//Date d = la[0].get(0);

		List<Date>[] lda = new ArrayList[5];
		Object [] foo = lda;
		foo[0] = "foo";
		List<Date> ld = lda[0];

	}

}
