//file: RemoteServer.java
import java.rmi.*;
import java.util.*;

public interface RemoteServer extends Remote {
    Date getDate(  ) throws RemoteException;
    StringIterator getList() throws RemoteException;
    Object execute( WorkRequest work ) throws RemoteException;
    void asyncExecute( WorkRequest work, WorkListener listener ) 
		throws RemoteException;
}
