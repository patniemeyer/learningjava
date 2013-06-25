//file: Desktop.java
import javax.swing.*;

public class Desktop {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Desktop");

    JDesktopPane desktop = new JDesktopPane(  );
    for (int i = 0; i < 5; i++) {
      JInternalFrame internal =
          new JInternalFrame("Frame " + i, true, true, true, true);
      internal.setSize(180, 180);
      internal.setLocation(i * 20, i * 20);
      internal.setVisible(true);
      desktop.add(internal);
    }

    frame.setSize(300, 300);
	frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setContentPane(desktop);
    frame.setVisible(true);
  }
}
