//file:	Grid.java
import java.awt.*;
import javax.swing.*;

public class Grid extends JPanel {

  public Grid() {
    setLayout(new GridLayout(3,	2));
    add(new JButton("One"));
    add(new JButton("Two"));
    add(new JButton("Three"));
    add(new JButton("Four"));
    add(new JButton("Five"));
  }

  public static	void main(String[] args) {
    JFrame frame = new JFrame("Grid");
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setSize(200, 200);
    frame.setLocation(200, 200);
    frame.setContentPane(new Grid());
    frame.setVisible(true);
  }
}
