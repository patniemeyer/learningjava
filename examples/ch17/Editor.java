import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class Editor extends JFrame implements ActionListener 
{
  private JEditorPane textPane = new JEditorPane( );
  
  public Editor( ) {
    super("Editor v1.0");
    Container content = getContentPane( ); // unecessary in 1.5+
    content.add(new JScrollPane(textPane), BorderLayout.CENTER);
    JMenu menu = new JMenu("File");
    menu.add(makeMenuItem("Open"));
    menu.add(makeMenuItem("Save"));
    menu.add(makeMenuItem("Quit"));
    JMenuBar menuBar = new JMenuBar( );
    menuBar.add(menu);
    setJMenuBar(menuBar);
    setSize(300, 300);
	setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
  }
  
  public void actionPerformed(ActionEvent e) {
    String command = e.getActionCommand( );
    if (command.equals("Quit")) System.exit(0);
    else if (command.equals("Open")) loadFile( );
    else if (command.equals("Save")) saveFile( );
  }
  
  private void loadFile ( ) {
    JFileChooser chooser = new JFileChooser( );
    int result = chooser.showOpenDialog(this);
    if (result == JFileChooser.CANCEL_OPTION) return;
    try {
      File file = chooser.getSelectedFile( );
      java.net.URL url = file.toURL( );
      textPane.setPage(url);
    }
    catch (Exception e) {
      textPane.setText("Could not load file: " + e);
    }
  }
  
  private void saveFile( ) {
    JFileChooser chooser = new JFileChooser( );
    chooser.showSaveDialog(this);
    // Save file data...
  }
  
  private JMenuItem makeMenuItem( String name ) {
    JMenuItem m = new JMenuItem( name );
    m.addActionListener( this );
    return m;
  }

  public static void main(String[] s) { 
	new Editor().setVisible(true);
  }
}

