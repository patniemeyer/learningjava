
import java.io.*;
import java.net.*;
import java.util.logging.*;

public class LogListener {
        public static void main( String [] args ) throws IOException
        {
                int port = Integer.parseInt( args[0] );
                ServerSocket server = new ServerSocket( port );
                Socket client = server.accept();
                BufferedReader in = new BufferedReader( 
                        new InputStreamReader( client.getInputStream() ) );

                String line;
                while ( (line = in.readLine() ) != null )
                        System.out.println( line );
        }

}

