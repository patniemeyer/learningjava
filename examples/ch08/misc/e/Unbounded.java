
import java.util.*;
/** @author Pat Niemeyer (pat@pat.net) */

public class Unbounded 
{
	void hasNulls( Collection<?> c ) {
		for( Object o : c ) { }
	}

	void foo() {
		hasNulls( new ArrayList<String>() );
	}

}
