import java.util.*;

public class Swap
{
	List<?> swap( List<?> list ) {
		return swap( list );
	}

	<T> List<T> swap( List<T> list ) {
		T tmp = list.get( 0 );
		list.set( 0, list.get(1) );
		list.set( 1, tmp );
		return list;
	}

	public static void main( String [] args )
	{
	}

}
