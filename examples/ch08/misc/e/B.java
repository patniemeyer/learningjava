import java.util.*;

/*
	When subclassing in Java the best we 
*/
/*
	Start with extending an arbitrary type

	go through subclassing exercise
class B <E extends Date> 
{
	void take( E element ) { }

}

// this is ok, but unchecked warnings on all methods
//class C extends B { }
// when extending must limit the bounds again, else compiler warning that E is
// not within its bounds
class C<E extends Date> extends B<E> { }

class Main {
	public static void main( String[] args ) 
	{
		System.out.println("main");

		// unchecked warning
		// new C().take( new Date() );
		new C<Date>().take( new Date() );

		// a B<Date> is a B
		System.out.println( new B<Date>() instanceof B ); // true
		System.out.println( new B<Date>() instanceof B<Date> ); // error

		System.out.println("done");
	}
}

*/

/*
	Now have it extend itself

class B <E extends B> 
{
	void take( E element ) { }

}

class C<E extends B> extends B<E> { }

class Main {
	public static void main( String[] args ) 
	{
		System.out.println("main");

		// plain extends B all ok
		new B<B>();
		// here's the problem, any B works
		// A B<anything> is a still a B
		new B<B>().take( new B() ); 
		new B<B>().take( new B<B>() );
		new C<B>().take( new C<B>() );
		new C<B>().take( new B<B>() );
		new C<C>().take( new C<C>() );


		System.out.println("done");
	}
}

*/

/*
	Now try to limit param type to a specific paramaterization of B
*/
class B <E extends B<E>> 
{
	void take( E element ) { }

}

class C<E extends C<E>> extends B<E> { }

class Main {
	public static void main( String[] args ) 
	{
		System.out.println("main");

		//new C<C>(); // no
		//new C<B>();
		//new B<B>();

		System.out.println("done");
	}
}
