package learningjava.service;

public class MyObject 
{
	int intValue;
	String stringValue;

	public MyObject() { }

	public MyObject( int i, String s ) {
		this.intValue = i;
		this.stringValue = s;
	}

	public int getIntValue() { return intValue; }
	public void setIntValue( int intValue ) { this.intValue = intValue; }

	public String getStringValue() { 
		return stringValue; 
	}
	public void setStringValue( String stringValue ) { 
		this.stringValue = stringValue;
	}

	public String toString() {
		return String.format( "MyObject: %i, %s", intValue, stringValue );
	}
}
