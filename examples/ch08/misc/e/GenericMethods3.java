import java.util.*;

public class GenericMethods3 
{
	/*
	no...
	static <T> List<T> arrayToList( Object [] oa ) {
		List<T> lt = new ArrayList<T>();
		for( Object o : oa )
			lt.add( o );
		return lt;
	}
	*/

	static <T> T foo() 
	{ 
		Number num = new Integer(42);
		T t = num;
		return t ;
	}

	public static void main( String [] args )
	{
		Number n = foo();
	}

}
