package magicbeans;

import java.util.*;

public class Timer implements Runnable
{
	long delay = 200;
	Thread thread;
	boolean stopped = true;
	List<TimerListener> listeners = new ArrayList<TimerListener>();

	public Timer() { 
		start();
	}

	public void run() {
		while( !stopped )
		{
			fireEvent();
			try {
				Thread.sleep( delay );
			} catch ( InterruptedException e ) {
				return; // die
			}
		}
	}

	public void addTimerListener(TimerListener listener) {
		listeners.add( listener );
	}

	public void removeTimerListener(TimerListener listener) {
		listeners.remove( listener );
	}

	void fireEvent() {
		for ( TimerListener listener : listeners )
			listener.timerFired( new TimerEvent(this) );
	}

	public void setDelay( long delay ) { this.delay = delay; }
	public long getDelay() { return this.delay; }

	public boolean isRunning() { return !stopped; }
	public void setRunning( boolean b ) { 
		if ( b ) 
			start();
		else
			stop();
	}

	public synchronized void stop() { 
		if ( !stopped )
		{
			stopped = true;
			if ( thread != null )
				thread.interrupt();
		}
	}
	public synchronized void start() {
		if ( stopped )
		{
			stopped = false;
			thread = new Thread(this);
			thread.start();
		}
	}
}
