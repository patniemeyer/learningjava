//file: Lister.java
import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;

public class Lister {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Lister v1.0");
    
    // create a combo box
    String [] items = { "uno", "due", "tre", "quattro", "cinque",
                        "sei", "sette", "otto", "nove", "deici",
                        "undici", "dodici" };
    JComboBox comboBox = new JComboBox(items);
    comboBox.setEditable(true);

    // create a list with the same data model
    final JList list = new JList(comboBox.getModel( ));
    
    // create a button; when it's pressed, print out
    // the selection in the list
    JButton button = new JButton("Per favore");
    button.addActionListener(new ActionListener( ) {
      public void actionPerformed(ActionEvent ae) {
        Object[] selection = list.getSelectedValues( );
        System.out.println("-----");
        for ( Object s : selection )
          System.out.println( s );
      }
    });
    
    // put the controls the content pane
    Container c = frame.getContentPane(); // unecessary in 1.5+
    JPanel comboPanel = new JPanel();
    comboPanel.add(comboBox);
    c.add(comboPanel, BorderLayout.NORTH);
    c.add(new JScrollPane(list), BorderLayout.CENTER);
    c.add(button, BorderLayout.SOUTH);

    frame.setSize(200, 200);
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setVisible(true);
  }    
}

