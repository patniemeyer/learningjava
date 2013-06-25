import java.util.*;
import java.net.*;
import java.io.*;

public class ShowStates 
{

	public static void main( String [] args ) throws Exception
	{
		new Thread() {
			public void run() {
				try {
				new ServerSocket(1234).accept();
				} catch ( IOException e ) { }
			}
		}.start();
		Thread.sleep(2000);

		while( true ) 
		{
		Thread [] threads = new Thread [ 10 ]; // max threads
		int num = Thread.enumerate( threads );
		for( int i = 0; i < num; i++ )
		{
			System.out.println( threads[i] );
			System.out.println( threads[i].getState() );
		}
		Thread.sleep(1000);
		}
	}

}
