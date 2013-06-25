/*
public class HelloJava 
{
  public static void main( String[] args ) {
	System.out.println("Hello, Java!");
  }
}

public class HelloJava 
{
  public static void main( String[] args ) {
    javax.swing.JFrame frame = new javax.swing.JFrame( "Hello, Java!" );
    frame.setSize( 300, 300 );
    frame.setVisible( true );
  }
}


import javax.swing.*;
public class HelloJava 
{
  public static void main( String[] args ) {
    JFrame frame = new JFrame( "HelloJava" );
	JLabel label = new JLabel("Hello, Java!", JLabel.CENTER );
    frame.getContentPane().add( label );
    frame.setSize( 300, 300 );
    frame.setVisible( true );
  }
}
*/

import javax.swing.*;
public class HelloJava 
{
  public static void main( String[] args ) {
    JFrame frame = new JFrame( "HelloJava" );
    frame.add( new HelloComponent() );
    frame.setSize( 300, 300 );
    frame.setVisible( true );
  }
}
class HelloComponent extends JComponent {
  public void paintComponent( java.awt.Graphics g ) {
    g.drawString( "Hello, Java!", 125, 95 );
  }
}


