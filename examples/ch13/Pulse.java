//file: Pulse.java
import java.net.*;
import java.io.*;

public class Pulse {
    public static void main( String [] argv ) throws IOException {
        DatagramSocket s =
          new DatagramSocket( Integer.parseInt(argv[0]) );

        while ( true ) {
            DatagramPacket packet =
              new DatagramPacket( new byte [1024], 1024 );
            s.receive( packet );
            System.out.println( "packet length = "+packet.getData().length );
            String message = new String( packet.getData(), "UTF-8" );
            System.out.println( "Heartbeat from: "
              + packet.getAddress().getHostName()
              + " - " + message );
        }
    }
}
