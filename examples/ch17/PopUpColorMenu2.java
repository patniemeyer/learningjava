//file: PopUpColorMenu.java
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PopUpColorMenu2 implements ActionListener
{
  public PopUpColorMenu2() {
    JFrame frame = new JFrame("PopUpColorMenu v2.0");

	JPanel panel = new JPanel();
    JButton button = new JButton("Uno");
	button.setInheritsPopupMenu(true);
    panel.add(button);
    button = new JButton("Due");
	button.setInheritsPopupMenu(true);
    panel.add(button);
    button = new JButton("Tre");
	button.setInheritsPopupMenu(true);
    panel.add(button);

  	final JPopupMenu colorMenu = new JPopupMenu("Color");
    colorMenu.add(makeMenuItem("Red"));
    colorMenu.add(makeMenuItem("Green"));
    colorMenu.add(makeMenuItem("Blue"));
	panel.setComponentPopupMenu( colorMenu );
	panel.setBackground(Color.BLUE);

	frame.setBackground( Color.RED );
	frame.add( BorderLayout.CENTER, panel );
	frame.setSize(200,50);
	frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setVisible(true);
  }

  public void actionPerformed( ActionEvent e ) {
  	System.out.println( e );
  	System.out.println( e.getSource() );
	/*
    String color = e.getActionCommand();
    if (color.equals("Red"))
      selectedComponent.setBackground(Color.red);
    else if (color.equals("Green"))
      selectedComponent.setBackground(Color.green);
    else if (color.equals("Blue"))
      selectedComponent.setBackground(Color.blue);
	 */
  }

  private JMenuItem makeMenuItem(String label) {
    JMenuItem item = new JMenuItem(label);
    item.addActionListener( this );
    return item;
  }

  public static void main(String[] args) {
     new PopUpColorMenu2();
  }
}
