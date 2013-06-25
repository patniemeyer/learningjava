
public class E< T extends Throwable >
{
	void test( Class<T> type ) throws T { 
		throw type.newInstance();
	}

	static void foo() {
		new E<ClassNotFoundException>().test( Exception.class );
	}
}
