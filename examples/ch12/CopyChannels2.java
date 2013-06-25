import java.io.*;
import java.nio.*;
import java.nio.channels.*;

public class CopyChannels2 {
	public static void main( String [] args ) throws Exception
	{
		String fromFileName = args[0];
		String toFileName = args[1];
		FileChannel in = new FileInputStream( fromFileName ).getChannel();
		FileChannel out = new FileOutputStream( toFileName ).getChannel();
		
		ByteBuffer buff = ByteBuffer.allocateDirect( 32*1024 );

		while ( in.read( buff ) > 0 ) {
			buff.flip();
			out.write( buff );
			buff.clear();
		}

		in.close();
		out.close();
	}
}
