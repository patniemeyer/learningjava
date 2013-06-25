//file: ScrollPaneFrame.java
import javax.swing.*;

public class ScrollPaneFrame 
{
  public static void main(String[] args) {
    String filename = "Piazza di Spagna.jpg";
    if (args.length > 0)
      filename = args[0];

    JFrame frame = new JFrame("ScrollPaneFrame v1.0");
	JLabel image = new JLabel( new ImageIcon(filename) );
    frame.getContentPane().add( new JScrollPane(image) );

    frame.setSize(300, 300);
	frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setVisible(true);
  }
}
