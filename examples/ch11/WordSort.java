import java.io.*;
import java.util.*;

public class WordSort 
{
  public static void main(String[] args) throws IOException 
  {
    if ( args.length < 2 ) {
      System.out.println("Usage: WordSort inputfile outputfile");
      return;
    }
    String inputfile = args[0];
    String outputfile = args[1];


    /*  Create the word map. Each key is a word and each value is an
        Integer that represents the number of times the word occurs
        in the input file.
    */
    Map<String,Integer> map = new TreeMap<String,Integer>();

    Scanner scanner = new Scanner( new File(inputfile) );
    while ( scanner.hasNext() ) {
        String word = scanner.next();
        Integer count = map.get( word );
        count = ( count == null ? 1 : count +1 );
        map.put( word, count );
    }
    scanner.close();

    // get the map's keys 
    List<String> keys = new ArrayList<String>( map.keySet() );
	//Collections.sort( keys );

    // write the results to the output file
    PrintWriter out = new PrintWriter( new FileWriter(outputfile) );
    for ( String key : keys )
      out.println( key + " : " + map.get(key) );
    out.close();
  }
}
