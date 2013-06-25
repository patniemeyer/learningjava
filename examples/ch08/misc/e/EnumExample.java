
import java.util.*;

public class EnumExample
{
	public static void main( String [] args )
	{
		System.out.println( Cat.values());
		System.out.println( Cat.Persian.ordinal() ); // 0
		System.out.println( Cat.Himalayan.ordinal() ); // 1

		System.out.println( Cat.Persian.compareTo( Cat.ShortHair ) ); // -2
		System.out.println( Cat.Persian.compareTo( Cat.Himalayan) ); // -1
		System.out.println( Cat.ShortHair.compareTo( Cat.Persian ) ); // 2
		//System.out.println( Cat.Persian.compareTo("foo") );  // no!


		// to string and back within type
		System.out.println( Cat.Persian.name() ); // "Persian"
		System.out.println( Cat.Persian ); // "Persian"
		Cat cat = Enum.valueOf( Cat.class, "Persian" );
		System.out.println( "class = "+cat );

		System.out.println( Cat.Persian.getDeclaringClass() );  // Cat

		Weekdays.Saturday.foo();

		switch ( cat ) {
			case Persian: System.out.println("here");
		}

		//Cat cat = Cat.Simon;
		//System.out.println( Cat.Simon.getClass() );
		//new HashMap().put( Cat.Simon, "foo" );

	}

	private static void print( Object o ) { System.out.println(o); }
	private static void print( long o ) { System.out.println(o); }
	private static void print( double o ) { System.out.println(o); }
	private static long time() { return System.currentTimeMillis(); }
}
