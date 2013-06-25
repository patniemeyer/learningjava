//file: LoggerDaemon.java
import java.io.*;

class LoggerDaemon extends Thread {
    PipedReader in = new PipedReader(  );

    LoggerDaemon(  ) {
        start(  );
    }

    public void run(  ) {
        BufferedReader bin = new BufferedReader( in );
        String s;

        try {
           while ( (s = bin.readLine(  )) != null ) {
                // process line of data
                // ...
            }
        }
        catch (IOException e ) { }
    }

    PrintWriter getWriter(  ) throws IOException {
        return new PrintWriter( new PipedWriter( in ) );
    }
}
