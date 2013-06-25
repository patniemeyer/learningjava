//file: HeartBeat.java
import java.net.*;
import java.io.*;

public class HeartBeat2 {
    private String myHost;
    private int myPort;

    public HeartBeat2( String host, int port  ) {
        myHost = host;
        myPort = port;
    }

    public void sendMessage( String message ) {
        try {
            byte [] data = message.getBytes("UTF-8");
            InetAddress addr = InetAddress.getByName( myHost );
            DatagramPacket pack =
              new DatagramPacket( data, data.length, addr, myPort );
            DatagramSocket ds = new DatagramSocket();
            ds.send( pack );
            ds.close();
        } catch ( IOException e ) {
            System.out.println( e );  // Error creating socket
        }
    }

	public static void main( String[] args ) {
		String host = args[0];
		int port = Integer.parseInt( args[1] );
		HeartBeat2 hb = new HeartBeat2( host, port );
		hb.sendMessage( "Ping!" );
	}
}
