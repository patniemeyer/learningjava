//file: DinnerMenu.java
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DinnerMenu 
{
  public static void main(String[] args) {
    JFrame frame = new JFrame("Dinner Menu");

    // create the Utensils menu
    JMenu utensils = new JMenu("Utensils");
    utensils.setMnemonic(KeyEvent.VK_U);
    utensils.add(new JMenuItem("Fork"));
    utensils.add(new JMenuItem("Knife"));
    utensils.add(new JMenuItem("Spoon"));
    JMenu hybrid = new JMenu("Hybrid");
    hybrid.add(new JMenuItem("Spork"));
    hybrid.add(new JMenuItem("Spife"));
    hybrid.add(new JMenuItem("Knork"));
    utensils.add(hybrid);
    utensils.addSeparator(  );

    // do some fancy stuff with the Quit item
    JMenuItem quitItem = new JMenuItem("Quit");
    quitItem.setMnemonic(KeyEvent.VK_Q);
    quitItem.setAccelerator(
        KeyStroke.getKeyStroke(KeyEvent.VK_Q, Event.CTRL_MASK));
    quitItem.addActionListener(new ActionListener(  ) {
      public void actionPerformed(ActionEvent e) { System.exit(0); }
    });
    utensils.add(quitItem);

    // create the Spices menu
    JMenu spices = new JMenu("Spices");
    spices.setMnemonic(KeyEvent.VK_S);
    spices.add(new JCheckBoxMenuItem("Thyme"));
    spices.add(new JCheckBoxMenuItem("Rosemary"));
    spices.add(new JCheckBoxMenuItem("Oregano", true));
    spices.add(new JCheckBoxMenuItem("Fennel"));

    // create the Cheese menu
    JMenu cheese = new JMenu("Cheese");
    cheese.setMnemonic(KeyEvent.VK_C);
    ButtonGroup group = new ButtonGroup(  );
    JRadioButtonMenuItem rbmi;
    rbmi = new JRadioButtonMenuItem("Regular", true);
    group.add(rbmi);
    cheese.add(rbmi);
    rbmi = new JRadioButtonMenuItem("Extra");
    group.add(rbmi);
    cheese.add(rbmi);
    rbmi = new JRadioButtonMenuItem("Blue");
    group.add(rbmi);
    cheese.add(rbmi);

    // create a menu bar and use it in this JFrame
    JMenuBar menuBar = new JMenuBar(  );
    menuBar.add(utensils);
    menuBar.add(spices);
    menuBar.add(cheese);
    frame.setJMenuBar(menuBar);

	frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	frame.setSize(200,200);
    frame.setVisible(true);
  }
}
