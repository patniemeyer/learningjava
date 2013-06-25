class Base { }
class Sub1 extends Base implements Runnable { public void run() { } }
class Sub2 extends Base implements Runnable { public void run() { } }

public class TypeInference 
{
	static <T extends Base> T infer( T t1, T t2 ) { return null; }

	public static void main( String [] args )
	{
		Base base = infer( new Sub1(), new Sub2() );
		// Note: Eclipse 3.1 says this is an error, but it's not
		Runnable runnable = infer( new Sub1(), new Sub2() );
	}

}
