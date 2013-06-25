import java.util.*;

interface A { static int FOO=1; String getFoo(); }
interface B { static int FOO=2; Date getDoo(); }

public class Cast2<T extends A & B>
{
	public void foo( T t )
	{
		System.out.println( t.FOO );
	}

}
