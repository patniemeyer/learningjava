import magicbeans.sunw.demo.juggler.Juggler;
import java.io.*;

public class SerializeJuggler {
	public static void main( String [] args ) throws Exception
	{
		Juggler duke = new Juggler(  );
		ObjectOutputStream oout = new ObjectOutputStream(
			new FileOutputStream("juggler.ser") );
		oout.writeObject( duke );
		oout.close();
	}
}
