import java.util.*;

/**
	
	@author Pat Niemeyer (pat@pat.net)
*/
interface Extending extends List<String>
{

}

interface ThreadList extends List<Thread>
{
}

class A {
	void go() { 
		ThreadList tl = null;
		Thread t = tl.get(1);
	}
}
