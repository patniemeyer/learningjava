//file: PopUpColorMenu.java
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PopUpColorMenu implements ActionListener
{
  Component selectedComponent;

  public PopUpColorMenu() {
    JFrame frame = new JFrame("PopUpColorMenu v1.0");

  	final JPopupMenu colorMenu = new JPopupMenu("Color");
    colorMenu.add(makeMenuItem("Red"));
    colorMenu.add(makeMenuItem("Green"));
    colorMenu.add(makeMenuItem("Blue"));

    MouseListener mouseListener = new MouseAdapter() {
      public void mousePressed(MouseEvent e) { checkPopup(e); }
      public void mouseClicked(MouseEvent e) { checkPopup(e); }
      public void mouseReleased(MouseEvent e) { checkPopup(e); }
      private void checkPopup(MouseEvent e) {
        if (e.isPopupTrigger(  )) {
          selectedComponent = e.getComponent(  );
          colorMenu.show(e.getComponent(), e.getX(), e.getY(  ));
        }
      }
    };

    Container content = frame.getContentPane(); // unecessary in 1.5+
    content.setLayout(new FlowLayout(  ));
    JButton button = new JButton("Uno");
    button.addMouseListener(mouseListener);
    content.add(button);
    button = new JButton("Due");
    button.addMouseListener(mouseListener);
    content.add(button);
    button = new JButton("Tre");
    button.addMouseListener(mouseListener);
    content.add(button);

    frame.getContentPane().addMouseListener(mouseListener);

	frame.setSize(200,50);
	frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {
    String color = e.getActionCommand(  );
    if (color.equals("Red"))
      selectedComponent.setBackground(Color.red);
    else if (color.equals("Green"))
      selectedComponent.setBackground(Color.green);
    else if (color.equals("Blue"))
      selectedComponent.setBackground(Color.blue);
  }

  private JMenuItem makeMenuItem(String label) {
    JMenuItem item = new JMenuItem(label);
    item.addActionListener( this );
    return item;
  }

  public static void main(String[] args) {
     new PopUpColorMenu();
  }
}
