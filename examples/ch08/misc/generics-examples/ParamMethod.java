import java.util.*;

public class ParamMethod
{
	<T,U extends T> void add2(List<T> to, List<U> from) {
	  //for (Iterator<U extends T> i = from.iterator(); i.hasNext(); )
	      //to.add(i.next());
	}

	<T,U,V> void tuv() { }
	<T,U super T,V> void tuv2() { }
}

