//file: MyStringIterator.java
import java.rmi.*;

public class MyStringIterator
  extends java.rmi.server.UnicastRemoteObject
  implements StringIterator {

    String [] list;
    int index = 0;

    public MyStringIterator( String [] list )
      throws RemoteException {
        this.list = list;
    }
    public boolean hasNext(  ) throws RemoteException {
        return index < list.length;
    }
    public String next(  ) throws RemoteException {
        return list[index++];
    }
}
