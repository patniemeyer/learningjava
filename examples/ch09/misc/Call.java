import java.util.*;
import java.util.concurrent.*;

public class Call 
{

	public static void main( String [] args )
	{
		new Callable<Integer>() {
			public Integer call() { return 2+2; }
		};
	}

}
