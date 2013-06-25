//file: MangoMango2.java
import java.awt.*;
import javax.swing.*;

public class MangoMango2 {
  public static void main(String[] args) {
    JFrame frame = new JFrame("The Frame");

    Container content = new JPanel(  );
    content.add(new JLabel("Mango"));
    content.add(new JButton("Mango"));
    frame.setContentPane(content);

    frame.setLocation(100, 100);
    frame.pack();
    frame.setVisible(true);
  }
}
