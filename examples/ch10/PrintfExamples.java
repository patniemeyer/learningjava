import java.util.*;
import static java.lang.System.*;

public class PrintfExamples
{
	public static void main( String [] args )
	{
		System.out.printf("a %1$s is a %1$s is a %1$s...", "rose" );
		System.out.printf("bool is %b\n", "a" );

		//char value is a
		System.out.printf("char value is %c\n", 'a' );
		// why doesn't this work?
		//System.out.printf("char value is %1$c, %1$C\n", 'a' );

		Date date = new Date(1099629120657L);

		//The date is Wed Oct 20 01:45:17 CDT 2004
		System.out.printf("The date is %s\n", date );
		//The date is Wed Oct 20 01:45:17 CDT 2004
		System.out.printf("The date is %tc\n", date );
		//The DATE is WED OCT 20 01:45:17 CDT 2004
		System.out.printf("The DATE is %Tc\n", date );

		System.out.printf("The DATE is %tD\n", date );
		System.out.printf("The DATE is %tF\n", date );
		System.out.printf("The DATE is %tr\n", date );
		System.out.printf("The DATE is %tR\n", date );
		System.out.printf("The DATE is %tT\n", date );

		System.out.printf( Locale.ITALIAN, "The date is %tc\n", date );
		System.out.printf( Locale.CHINA, "The date is %tc\n", date );
		System.out.printf( Locale.FRENCH, "The date is %tc\n", date );
		System.out.printf( Locale.GERMAN, "The date is %tc\n", date );

		System.out.printf("The DATE is %tC\n", date );
		System.out.printf("The DATE is %tz\n", date );

		System.out.printf("String is '%5s'\n", "A");
		System.out.printf("String is '%-5s'\n", "A");
		System.out.printf("String is '%.5s'\n", "Happy Birthday!");

		String [] words = 
			new String [] { "abalone", "ape", "antidisestablishmentarianism" };
		System.out.printf( "%-10s %s\n", "Word", "Length" );
		for ( String word : words )
			System.out.printf( "%-10.10s %s\n", word, word.length() );

		out.printf("num is %s\n", 5);
		out.printf("char is %s\n", 'a');
		out.printf("char is %S\n", 'a');
		out.printf("bool is %s\n", true );

		//My name is Joe
		System.out.printf("My name is %s\n", "Joe");
		//http://host/path
		System.out.printf("%s://%s/%s\n", "http", "host", "path");
		//http://host/path
		System.out.printf("%1$s://%2$s/%3$s\n", "http", "host", "path");

		// num is 3.141593
		out.printf("num is %f\n", Math.PI );
		// num is 3.14
		out.printf("num is %.2f\n", Math.PI );

		//num is 005
		out.printf("num is %03d\n", 5 );

		out.printf("num is %03f\n", 3.14159265 );
		out.printf("num is {%07.3f}\n", 3.14 );
		out.printf("06.3 num is %06.3f\n", 3.14159265 );
		out.printf(".3 num is %.3f\n", 3.14159265 );
		out.printf("9.99 num is %4.2f\n", 9.999999999 );

		out.printf("1.0 5f num is %5f\n", 1.0 );
		out.printf("1.0 4f num is %4f\n", 1.0 );

		out.printf("sci not num is %e\n", 3.14159265*10000 );
		out.printf("sci not num is %g\n", 3.14159265*10000 );
		out.printf("sci not num is %e\n", 0.123456789 );
		out.printf("sci not num is %g\n", 0.123456789 );
		out.printf("sci not num is %e\n", 3000000.0 );
		out.printf("hex num is %h\n", 1.0 );
		out.printf("num is %h\n", 0xCAFE );


		//boolean value is true, TRUE
		System.out.printf("boolean value is %1$b, %1$B\n", true );

		//hex value is b5151397, B5151397
		System.out.printf("hex value is %1$h, %1$H\n", new Date() );
		//hex value 
		System.out.printf("hex value is %1$h, %1$H\n", 0xCAFE );
		//hex value 
		System.out.printf("hex value is %1$x, %1$X\n", 0xCAFE );
		System.out.printf("hex value is %1$#x, %1$#X\n", 0xCAFE );

		System.out.printf( Locale.ITALIAN, "value: %f\n", 3.14 );

		// flags
		out.printf("num is %d\n", 5000000);

		out.printf("float is %f\n", 1.23456789);
		out.printf("float is %.3f\n", 1.23456789);
		out.printf("float is %.1f\n", 1.23456789);
		out.printf("float is %.0f\n", 1.23456789);

		out.printf("float is %-20f!\n", 1.23456789);
	}

}
