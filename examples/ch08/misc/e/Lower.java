import java.util.*;

class MyDate extends Date { }

public class Lower 
{

	public static void main( String [] args )
	{
		List< ? extends Date super MyDate > lsd = new ArrayList<Date>();
		//lsd.add( new Date() );
		lsd.add( new MyDate() );
		Object o = lsd.get( 0 );

	}

}
