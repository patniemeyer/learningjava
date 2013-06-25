//file: Save.java
import java.io.*;
import java.util.*;

public class Save {
  public static void main(String[] args) {
    Hashtable h = new Hashtable(  );
    h.put("string", "Gabriel Garcia Marquez");
    h.put("int", new Integer(26));
    h.put("double", new Double(Math.PI));

    try {
      FileOutputStream fileOut = new FileOutputStream("h.ser");
      ObjectOutputStream out = new ObjectOutputStream(fileOut);
      out.writeObject(h);
    }
    catch (Exception e) {
      System.out.println(e);
    }
  }
}
