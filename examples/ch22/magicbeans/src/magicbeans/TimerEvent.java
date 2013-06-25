package magicbeans;

import java.awt.*;

public class TimerEvent extends java.util.EventObject {
	int value;

	TimerEvent( Timer source ) {
		super( source );
	}
}
