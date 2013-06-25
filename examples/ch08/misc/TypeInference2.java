//package .export.home.space.pat.lj5.generics;
/** @author Pat Niemeyer (pat@pat.net) */
import java.util.*;

public class TypeInference2
{
	static <T> T infer( T t1, T t2 ) { return null; }

	public static void main( String [] args )
	{
		infer( "foo", new Date() );
	}

}
