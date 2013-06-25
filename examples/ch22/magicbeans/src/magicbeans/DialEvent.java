package magicbeans;

import java.awt.*;

public class DialEvent extends java.util.EventObject {
	int value;

	DialEvent( Dial source, int value ) {
		super( source );
		this.value = value;
	}
	public int getValue() {
		return value;
	}
}
