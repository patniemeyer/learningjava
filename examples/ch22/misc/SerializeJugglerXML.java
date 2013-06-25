import magicbeans.sunw.demo.juggler.Juggler;
import java.io.*;

/*
	Not implemented by bean deserialization.
*/
public class SerializeJugglerXMl {
	public static void main( String [] args ) throws Exception
	{
		Juggler duke = new Juggler(  );
		// no, Encoder... XMLOutputStream xmlout = new XMLOutputStream(
			new FileOutputStream("juggler.xml") );
		xmlout.writeObject( duke );
		xmlout.close();
	}
}
