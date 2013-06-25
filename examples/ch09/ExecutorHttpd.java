import java.net.*;
import java.io.*;
import java.util.regex.*;
import java.util.concurrent.*;

public class ExecutorHttpd 
{
  ExecutorService executor = Executors.newFixedThreadPool(3);

  public void start( int port ) throws IOException
  {
    final ServerSocket ss = new ServerSocket( port );
    while ( !executor.isShutdown() )
      executor.submit( new TinyHttpdConnection( ss.accept() ) );
  }

  public void shutdown() throws InterruptedException {
    executor.shutdown();
    executor.awaitTermination( 30, TimeUnit.SECONDS );
    executor.shutdownNow();
  }

  public static void main( String argv[] ) throws Exception 
  {
    new ExecutorHttpd().start( Integer.parseInt(argv[0]) );
  }
}

/*
  This class is copied from the TinyHttpd example in Chapter 13.
class TinyHttpdConnection implements Runnable {
  Socket client;
  TinyHttpdConnection ( Socket client ) throws SocketException {
    this.client = client;
  }
  public void run() {
    try {
      BufferedReader in = new BufferedReader(
        new InputStreamReader(client.getInputStream(), "8859_1" ) );
      OutputStream out = client.getOutputStream();
      PrintWriter pout = new PrintWriter(
        new OutputStreamWriter(out, "8859_1"), true );
      String request = in.readLine();
      System.out.println( "Request: "+request);

    Matcher get = Pattern.compile("GET /?(\\S*).*").matcher( request );
    if ( get.matches() ) {
    request = get.group(1);
        if ( request.endsWith("/") || request.equals("") )
          request = request + "index.html";
        try {
          FileInputStream fis = new FileInputStream ( request );
          byte [] data = new byte [ 64*1024 ];
      for(int read; (read = fis.read( data )) > -1; )
        out.write( data, 0, read );
          out.flush();
        } catch ( FileNotFoundException e ) {
          pout.println( "404 Object Not Found" ); }
      } else
        pout.println( "400 Bad Request" );
      client.close();
    } catch ( IOException e ) {
      System.out.println( "I/O error " + e ); }
  }
}
*/

