import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ContextMenu implements ActionListener
{
  JTextArea textArea = new JTextArea();

  public ContextMenu() 
  {
  	final JPopupMenu contextMenu = new JPopupMenu("Edit");
    contextMenu.add(makeMenuItem("Save"));
    contextMenu.add(makeMenuItem("Save As"));
    contextMenu.add(makeMenuItem("Close"));

    JFrame frame = new JFrame("ContextMenu v1.0");
	JPanel panel = new JPanel();
	panel.setLayout( new BorderLayout() );
	frame.add( panel );
	panel.setComponentPopupMenu( contextMenu );

	textArea.setInheritsPopupMenu( true );
	panel.add( BorderLayout.CENTER, textArea );

	JTextField textField = new JTextField();
	textField.setInheritsPopupMenu( true );
	panel.add( BorderLayout.SOUTH, textField );

	frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	frame.setSize(400,200);
    frame.setVisible(true);
  }

  public void actionPerformed( ActionEvent e ) {
    textArea.append( e.getActionCommand() +"\n" );
  }

  private JMenuItem makeMenuItem(String label) {
    JMenuItem item = new JMenuItem(label);
    item.addActionListener( this );
    return item;
  }

  public static void main(String[] args) {
     new ContextMenu();
  }
}
