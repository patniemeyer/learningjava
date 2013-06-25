import java.util.*;

public class GM 
{
	static void foo( List<String> ls ) { }
	static <T> void bar( T t ) { }

	public static void main( String [] args )
	{
		foo( new ArrayList<String>() );
		bar( new ArrayList<String>() );
	}

}
