import java.util.*;

interface Foo {
	public int X=42;
	void foo();
}
interface Bar {
	public int X=43;
	void bar();
}
/**
	
	@author Pat Niemeyer (pat@pat.net)
*/
public class Bounds<E extends Runnable & Foo & Bar>
{
	void go(E e) {
		int i = e.X;
	}

	public static void main( String [] args )
	{
	}

}
