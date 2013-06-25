public class UpdateApplet extends java.applet.Applet
    implements Runnable 
{
	Thread thread;
    boolean running;
    int updateInterval = 1000;

    public void run() {
        while ( running ) 
		{
            repaint();
            try {
                Thread.sleep( updateInterval );
            } catch ( InterruptedException e ) {
				System.out.println("interrupted...");
                return;
            }
        }
    }

    public void start() {
		System.out.println("starting...");
        if ( !running ) // naive approach
		{
			running = true;
            thread = new Thread(this);
            thread.start();
		}
    }

    public void stop() {
		System.out.println("stopping...");
		thread.interrupt();
		running = false;
    }
}
