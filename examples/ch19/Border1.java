//file:	Border1.java
import java.awt.*;
import javax.swing.*;

public class Border1 extends JPanel {

  public Border1() {
    setLayout(new BorderLayout(	));
    add(new JButton("North"), BorderLayout.NORTH);
    add(new JButton("South"), BorderLayout.SOUTH);
    add(new JButton("East"), BorderLayout.EAST);
    add(new JButton("West"), BorderLayout.WEST);
    add(new JButton("Center"), BorderLayout.CENTER);
  }

  public static	void main(String[] args) {
    JFrame frame = new JFrame("Border1");
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setSize(300, 300);
    frame.setLocation(200, 200);
    frame.setContentPane(new Border1());
    frame.setVisible(true);
  }
}
