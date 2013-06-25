//file: NoisyButton.java
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NoisyButton {

  public static void main(String[] args) throws Exception {
    JFrame frame = new JFrame("NoisyButton");
    java.io.File file = new java.io.File( args[0] );
    final AudioClip sound = Applet.newAudioClip(file.toURL(  ));

    // set up the button
    JButton button = new JButton("Woof!");
    button.addActionListener(new ActionListener(  ) {
      public void actionPerformed(ActionEvent e) { sound.play(  ); }
    });

	Container content = frame.getContentPane();
    content.setBackground(Color.pink);
    content.setLayout(new GridBagLayout());
    content.add(button);
    frame.setVisible(true);
    frame.setSize(200, 200);
	frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	frame.setVisible(true);
  }
}
