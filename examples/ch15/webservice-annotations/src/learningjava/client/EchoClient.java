package learningjava.client;

import learningjava.client.impl.*;
import learningjava.client.impl.Echo;
import learningjava.client.impl.MyObject;

public class EchoClient
{
	public static void main( String [] args ) throws java.rmi.RemoteException
	{
        Echo service = new EchoService().getEchoPort();
        int i = service.echoInt( 42 );
		System.out.println( i );
		String s = service.echoString( "Hello!" );
		System.out.println( s );
        MyObject myObject = new MyObject();
        myObject.setIntValue( 42 );
        myObject.setStringValue( "Foo!" );
        MyObject myObj = service.echoMyObject( myObject );
		System.out.println( myObj.getStringValue() );

        new learningjava.service.Echo();
	}
}
