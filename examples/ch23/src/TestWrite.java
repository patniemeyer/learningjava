import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class TestWrite extends JApplet 
	implements ActionListener
{
	JTextArea ta = new JTextArea();

	public void init() {
		JButton button = new JButton("Test Write");
		button.addActionListener( this );
		JPanel p = new JPanel();
		p.add( button );
		getContentPane().add( "North", p );
		getContentPane().add( "Center", new JScrollPane(ta) );
	}

	public void actionPerformed( ActionEvent e ) 
	{
		try {
			String fname = "." + File.separator + "testwrite.xxx";
			write("Attempting to write file: "+fname);
			FileOutputStream file = new FileOutputStream( fname );
			new PrintStream( file ).println("Hello...");
			file.close();
			write("Success!");
		} catch ( Exception e2 ) {
			write( "Caught Exception: " + e2 );
			write("Failed to write file...");
		}
	}

	private void write( String s ) {
		ta.append( s + "\n" );
	}
}

