import java.rmi.*;
import java.util.*;

public class MyClientAsync 
	extends java.rmi.server.UnicastRemoteObject implements WorkListener 
{

    public MyClientAsync(String host) throws RemoteException 
	{
        try {
            RemoteServer server = (RemoteServer)
                Naming.lookup("rmi://"+host+"/NiftyServer");

			StringIterator si = server.getList();
			while( si.hasNext() ) {
				System.out.println( si.next() );
			}

			server.asyncExecute( new MyCalculation(100), this );
        } catch (java.io.IOException e) {
			System.out.println(e);
            // I/O Error or bad URL
        } catch (NotBoundException e) {
			System.out.println(e);
            // NiftyServer isn't registered
        }
    }

	public void workCompleted( WorkRequest request, Object result ) 
		throws RemoteException 
	{
		System.out.println("Async result: "+result );
	}

    public static void main(String [] args) throws RemoteException {
        new MyClientAsync( args[0] );
    }

}
