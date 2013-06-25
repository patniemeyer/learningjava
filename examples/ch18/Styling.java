//file: Styling.java
import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;

public class Styling extends JFrame {
  private JTextPane textPane;

  public Styling() {
    super("Styling v1.0");
    setSize(300, 200);

    textPane = new JTextPane(  );
    textPane.setFont(new Font("Serif", Font.PLAIN, 24));

    // create some handy attribute sets
    SimpleAttributeSet red = new SimpleAttributeSet(  );
    StyleConstants.setForeground(red, Color.red);
    StyleConstants.setBold(red, true);
    SimpleAttributeSet blue = new SimpleAttributeSet(  );
    StyleConstants.setForeground(blue, Color.blue);
    SimpleAttributeSet italic = new SimpleAttributeSet(  );
    StyleConstants.setItalic(italic, true);
    StyleConstants.setForeground(italic, Color.orange);

    // add the text
    append("In a ", null);
    append("sky", blue);
    append(" full of people\nOnly some want to ", null);
    append("fly", italic);
    append("\nIsn't that ", null);
    append("crazy", red);
    append("?", null);

    Container content = getContentPane(  );
    content.add(new JScrollPane(textPane), BorderLayout.CENTER);
	setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
  }

  protected void append(String s, AttributeSet attributes) {
    Document d = textPane.getDocument(  );
    try { d.insertString(d.getLength(  ), s, attributes); }
    catch (BadLocationException ble) {}
  }

  public static void main(String[] args) {
    new Styling().setVisible(true);
  }
}
