import java.util.*;
import java.lang.reflect.*;

public class Reflect 
{

	public static void main( String [] args )throws Exception
	{
		Method method = Object.class.getDeclaredMethod( "clone" );
		System.out.println( Modifier.isProtected(method.getModifiers()) );
	}

}
