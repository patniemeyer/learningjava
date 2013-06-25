import java.nio.channels.*;
import java.nio.file.*;
import static java.nio.file.StandardOpenOption.*;

public class CopyFile
{
    public static void main( String [] args ) throws Exception
    {
        FileSystem fs = FileSystems.getDefault();
        Path fromFile = fs.getPath( args[0] );
        Path toFile = fs.getPath( args[1] );

        try (
            FileChannel in = FileChannel.open( fromFile );
            FileChannel out = FileChannel.open( toFile, CREATE, WRITE ); )
        {
            in.transferTo( 0, (int)in.size(), out );
        }
    }
}