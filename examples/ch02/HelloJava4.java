import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HelloJava4
{
  public static void main( String[] args ) {
    JFrame frame = new JFrame( "HelloJava4" );
    frame.add( new HelloComponent4("Hello Java!") );
	frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setSize( 300, 300 );
    frame.setVisible( true );
  }
}

class HelloComponent4 extends JComponent
    implements MouseMotionListener, ActionListener, Runnable 
{
  String theMessage;
  int messageX = 125, messageY = 95; // Coordinates of the message

  JButton theButton;

  int colorIndex; // Current index into someColors.
  static Color[] someColors = { 
	Color.black, Color.red, Color.green, Color.blue, Color.magenta };

  boolean blinkState;

  public HelloComponent4( String message ) {
    theMessage = message;
    theButton = new JButton("Change Color");
    setLayout( new FlowLayout() );
    add( theButton );
    theButton.addActionListener( this );
    addMouseMotionListener( this );
    Thread t = new Thread( this );
    t.start();
  }

  public void paintComponent( Graphics g ) {
    g.setColor(blinkState ? getBackground() : currentColor(  ));
    g.drawString(theMessage, messageX, messageY);
  }

  public void mouseDragged(MouseEvent e) {
    messageX = e.getX();
    messageY = e.getY();
    repaint();
  }

  public void mouseMoved(MouseEvent e) { }

  public void actionPerformed( ActionEvent e ) {
    if ( e.getSource() == theButton )
      changeColor();
  }

  synchronized private void changeColor() {
    if (++colorIndex == someColors.length)
      colorIndex = 0;
    setForeground( currentColor() );
    repaint();
  }

  synchronized private Color currentColor(  ) {
    return someColors[colorIndex];
  }

  public void run(  ) {
    try {
      while(true) {
        blinkState = !blinkState; // Toggle blinkState.
        repaint(); // Show the change.
        Thread.sleep(300);
      }
    } catch (InterruptedException ie) { }
  }
}
