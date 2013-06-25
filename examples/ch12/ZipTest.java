import java.io.*;
import java.net.URI;
import java.nio.file.*;
import java.util.*;

public class ZipTest
{
    public static void main( String[] args ) throws IOException
    {
        // Construct the URI pointing to the ZIP archive
        URI fsURI = URI.create("jar:file:/Users/pat/tmp/MyArchive.zip");

        // Open or creat it and write a file
        Map<String, String> env = new HashMap<>();
        //env.put("create", "true");
        try ( FileSystem zipfs = FileSystems.newFileSystem( fsURI, env ) )
        {
            Path path = zipfs.getPath("/README.txt");
            OutputStream out = Files.newOutputStream( path );
            try ( PrintWriter pw = new PrintWriter( new OutputStreamWriter( out ) ) ) {
                pw.println("Hello World!");
            }
        }

        // Move the file
        try ( FileSystem zipfs = FileSystems.newFileSystem( fsURI, env ) )
        {
            Path path = zipfs.getPath("/README.txt");
            Path toPath = zipfs.getPath( "/README2.txt" );
            Files.move( path, toPath );
        }

    }
}
