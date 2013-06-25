//file: MyServer.java
import java.rmi.*;
import java.util.*;

public class MyServer
    extends java.rmi.server.UnicastRemoteObject
    implements RemoteServer {

    public MyServer(  ) throws RemoteException { }

    // implement the RemoteServer interface
    public Date getDate(  ) throws RemoteException {
        return new Date(  );
    }

    public Object execute( WorkRequest work ) throws RemoteException {
        return work.execute(  );
    }

    public StringIterator getList() throws RemoteException {
      return new MyStringIterator(
          new String [] { "Foo", "Bar", "Gee" } );
    }

	public void asyncExecute( 
		final WorkRequest request, final WorkListener listener )
		throws RemoteException 
	{
		new Thread() {
			public void run() {
				try {
					Thread.sleep(1000);
				} catch ( Exception e ) { }
				
				Object result = request.execute(); 
				try {
					listener.workCompleted( request, result ); 
				} catch ( RemoteException e ) {
					System.out.println( e ); // error calling client
				}
			}}.start();
	}

    public static void main(String args[]) {
        try {
            RemoteServer server = new MyServer(  );
            Naming.rebind("NiftyServer", server);
        } catch (java.io.IOException e) {
            // problem registering server
        }
    }
}
