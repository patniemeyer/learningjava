//file: Client.java
import java.net.*;
import java.io.*;

public class Client {
  public static void main( String argv[] ) {
    try {
      Socket server =
        new Socket( argv[0], Integer.parseInt(argv[1]) );
      ObjectOutputStream out =
        new ObjectOutputStream( server.getOutputStream(  ) );
      ObjectInputStream in =
        new ObjectInputStream( server.getInputStream(  ) );

      out.writeObject( new DateRequest(  ) );
      out.flush(  );
      System.out.println( in.readObject(  ) );

      out.writeObject( new MyCalculation( 2 ) );
      out.flush(  );
      System.out.println( in.readObject(  ) );

      server.close(  );
    } catch ( IOException e ) {
      System.out.println( "I/O error " + e ); // I/O error
    } catch ( ClassNotFoundException e2 ) {
      System.out.println( e2 ); // unknown type of response object
    }
  }
}
