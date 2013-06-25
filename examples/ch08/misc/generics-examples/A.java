import java.util.*;

public class A<E extends Date>
{
	E get() { return null; }
}

class B 
{ 
	<T extends Date> void take( T date ) { }

	void go() 
	{
		A<String> a = new A<String>();
		String s = a.get();
		//List<?> wordlist = new ArrayList<?>();
		Vector [] v = new Vector<?>[10];
	}
}
