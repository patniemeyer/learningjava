import java.util.*;

public class MathUtils {

    public static <T> T max( T x, T y ) { 
		if ( x > y )
			return x;
		else
			return y;
	}    

	public static void main( String [] args )
	{
		Long l = MathUtils.<Long>max( 42L, 42L );
	}

}
