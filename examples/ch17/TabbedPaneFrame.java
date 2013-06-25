//file: TabbedPaneFrame.java
import javax.swing.*;

public class TabbedPaneFrame {
  public static void main(String[] args) 
  {
    JFrame frame = new JFrame("TabbedPaneFrame");
    JTabbedPane tabby = new JTabbedPane();

    // create the controls pane
    JPanel controls = new JPanel(  );
    controls.add(new JLabel("Service:"));
    JList list = new JList(
        new String[] { "Web server", "FTP server" });
    list.setBorder(BorderFactory.createEtchedBorder(  ));
    controls.add(list);
    controls.add(new JButton("Start"));

    // create an image pane
    String filename = "Piazza di Spagna.jpg";
	JLabel image = new JLabel( new ImageIcon(filename) );
    JComponent picture = new JScrollPane(image);
    tabby.addTab("Controls", controls);
    tabby.addTab("Picture", picture);

    frame.getContentPane().add(tabby);

    frame.setSize(200, 200);
	frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setVisible(true);
  }
}
