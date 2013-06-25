//file:	Boxer.java
import java.awt.*;
import javax.swing.*;

public class Boxer extends JPanel {
  public static	void main(String[] args) {
    JFrame frame = new JFrame("Boxer");
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setSize(250, 250);
    frame.setLocation(200, 200);
    Container box = Box.createHorizontalBox();
    box.add(Box.createHorizontalGlue());
    box.add(new	JButton("In the"));
    box.add(Box.createHorizontalGlue());
    box.add(new	JButton("clearing"));
    box.add(Box.createHorizontalStrut(10));
    box.add(new	JButton("stands"));
    box.add(Box.createHorizontalStrut(10));
    box.add(new	JButton("a"));
    box.add(Box.createHorizontalGlue());
    box.add(new	JButton("boxer"));
    box.add(Box.createHorizontalGlue());
    frame.getContentPane().add(box, BorderLayout.CENTER);
    frame.pack(	);
    frame.setVisible(true);
  }
}
