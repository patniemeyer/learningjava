import java.util.*;

public class Variant 
{
	Object get() { return null; }
}

class Variant2 extends Variant
{
	Date get() { return (Date)super.get(); }
}

class Variant3 {
	public static void main(String [] args) {
		Date d = new Variant2().get();
	}
}
