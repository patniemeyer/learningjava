package magicbeans;

public class Trivial implements java.io.Serializable {
	boolean foo = false;
	public void setFoo( boolean b ) {
		foo=b;
	}
	public boolean getFoo() {
		return foo;
	}

	boolean bar = false;
	public void setBar( boolean b ) {
		bar=b;
	}
	public boolean isBar() {
		return bar;
	}
}
