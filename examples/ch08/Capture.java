import java.util.*;

public class Capture 
{

	static <T> Set<T> listToSet( List<T> list ) { 
		Set<T> set = new HashSet<T>();
		set.addAll( list );
		return set;
	}

	public static void main( String [] args ) 
	{
		List<?> list = new ArrayList<Date>();
		Set<?> set = listToSet( list );
	}
}
