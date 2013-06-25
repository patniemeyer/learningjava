//file: MangoMango1.java
import java.awt.*;
import javax.swing.*;

public class MangoMango1 {
  public static void main(String[] args) {
    JFrame frame = new JFrame("The Frame");

    Container content = frame.getContentPane(  );
    content.setLayout(new FlowLayout(  ));
    content.add(new JLabel("Mango"));
    content.add(new JButton("Mango"));

    frame.setLocation(100, 100);
    frame.pack();
    frame.setVisible(true);
  }
}
