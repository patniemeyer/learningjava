//file: DynamicHookup.java
import javax.swing.*;
import java.awt.event.*;
import java.beans.EventHandler;

public class DynamicHookup extends JFrame {
  JLabel label = new JLabel( "Ready...", JLabel.CENTER );
  int count;

  public DynamicHookup() {
    JButton launchButton = new JButton("Launch!");
    getContentPane().add( launchButton, "South" );
    getContentPane().add( label, "Center" );
	launchButton.addActionListener( 
		(ActionListener)EventHandler.create(
			ActionListener.class, this, "launchTheMissiles"));
  }

  public void launchTheMissiles() {
    label.setText("Launched: "+ count++ );
  }

  public static void main( String[] args ) {
    JFrame frame = new DynamicHookup();
	frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setSize(150, 150);
    frame.setVisible( true );
  }
}
