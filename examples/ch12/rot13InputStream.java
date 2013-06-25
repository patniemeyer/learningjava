//file: rot13InputStream.java
package learningjava.io;
import java.io.*;

public class rot13InputStream extends FilterInputStream {

    public rot13InputStream ( InputStream i ) {
        super( i );
    }

    public int read(  ) throws IOException {
        return rot13( in.read(  ) );
    }

    private int rot13 ( int c ) {
        if ( (c >= 'A') && (c <= 'Z') )
            c=(((c-'A')+13)%26)+'A';
        if ( (c >= 'a') && (c <= 'z') )
            c=(((c-'a')+13)%26)+'a';
        return c;
    }
}
