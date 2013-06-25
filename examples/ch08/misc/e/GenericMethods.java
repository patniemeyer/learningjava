import java.util.*;

public class GenericMethods
{

	static <A,B> A doit( B b ) { return null; }


	public static void main( String [] args ) 
	{
		String s = doit( 42 );
	}

}
