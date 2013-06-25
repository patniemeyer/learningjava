//file: Load.java
import java.io.*;
import java.util.*;

public class Load {
  public static void main(String[] args) {
    try {
      FileInputStream fileIn = new FileInputStream("h.ser");
      ObjectInputStream in = new ObjectInputStream(fileIn);
      Hashtable h = (Hashtable)in.readObject(  );
      System.out.println(h.toString(  ));
    }
    catch (Exception e) {
      System.out.println(e);
    }
  }
}
