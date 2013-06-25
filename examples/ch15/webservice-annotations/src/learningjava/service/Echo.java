package learningjava.service;

import javax.jws.*;
import javax.xml.ws.Endpoint;

@WebService
public class Echo
{
    @WebMethod
    public int echoInt( int value ) { return value; }

    @WebMethod
    public String echoString( String value ) { return value; }

    @WebMethod
    public MyObject echoMyObject( MyObject value ) { return value; }

    public static void main( String[] args )
    {
        Endpoint.publish( "http://localhost:8080/echo", new Echo() );
    }
}

