//file: GUnzip.java
import java.io.*;
import java.util.zip.*;

public class GUnzip {
  public static int sChunk = 8192;
  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println("Usage: GUnzip source");
      return;
    }
    // create input stream
    String zipname, source;
    if (args[0].endsWith(".gz")) {
      zipname = args[0];
      source = args[0].substring(0, args[0].length(  ) - 3);
    }
    else {
      zipname = args[0] + ".gz";
      source = args[0];
    }
    GZIPInputStream zipin;
    try {
      FileInputStream in = new FileInputStream(zipname);
      zipin = new GZIPInputStream(in);
    }
    catch (IOException e) {
      System.out.println("Couldn't open " + zipname + ".");
      return;
    }
    byte[] buffer = new byte[sChunk];
    // decompress the file
    try {
      FileOutputStream out = new FileOutputStream(source);
      int length;
      while ((length = zipin.read(buffer, 0, sChunk)) != -1)
        out.write(buffer, 0, length);
      out.close(  );
    }
    catch (IOException e) {
      System.out.println("Couldn't decompress " + args[0] + ".");
    }
    try { zipin.close(  ); }
    catch (IOException e) {}
  }
}
