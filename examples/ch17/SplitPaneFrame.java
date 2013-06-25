//file: SplitPaneFrame.java
import java.awt.*;
import javax.swing.*;

public class SplitPaneFrame {
  public static void main(String[] args) {
    String fileOne = "Piazza di Spagna.jpg";
    String fileTwo = "L1-Light.jpg";
    if (args.length > 0) fileOne = args[0];
    if (args.length > 1) fileTwo = args[1];

    JFrame frame = new JFrame("SplitPaneFrame");

	JLabel leftImage = new JLabel( new ImageIcon( fileOne ) );
    Component left = new JScrollPane(leftImage);
	JLabel rightImage = new JLabel( new ImageIcon( fileTwo ) );
    Component right = new JScrollPane(rightImage);

    JSplitPane split =
      new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, left, right);
    split.setDividerLocation(100);
    frame.getContentPane().add(split);

	frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setSize(300, 200);
    frame.setVisible(true);
  }
}
