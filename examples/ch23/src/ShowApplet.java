import javax.swing.*;
import java.awt.event.*;

public class ShowApplet extends JApplet {
	JTextArea text = new JTextArea();
	int startCount;

	public void init() 
	{
		JButton button = new JButton("Press Me");
		button.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent e ) {
				text.append("Button Pressed!\n"); 
			}
		} );
		getContentPane().add( "Center", new JScrollPane( text ) );
		JPanel panel = new JPanel();
		panel.add( button );
		getContentPane().add( "South", panel );
		text.append( "Java Version: "+System.getProperty("java.version")+"\n" );
		text.append( "Applet init()\n" );
	}
	public void start() {
		text.append( "Applet started: "+ startCount++ +"\n" );
	}
	public void stop() {
		text.append( "Applet stopped.\n" );
	}
}

