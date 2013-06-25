import java.util.*;


public class Bounds1 < T extends java.io.Serializable & Runnable >
{
	Runnable r;

	public void take( T t ) { 
		this.r = t;
	}

	public T get() { return null; }
}
/*

class MyDate extends Date { }

class Main {

	public static void main( String [] args ) 
	{
		Bounds1<MyDate> bd = new Bounds1<MyDate>();
		bd.take( new MyDate() );
		MyDate md = bd.get();
	}
}
*/
