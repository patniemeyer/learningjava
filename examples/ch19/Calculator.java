//file:	Calculator.java
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator	extends	JPanel implements ActionListener {
  GridBagConstraints gbc = new GridBagConstraints();
  JTextField theDisplay	= new JTextField();

  public Calculator() {
    gbc.weightx	= 1.0;	gbc.weighty = 1.0;
    gbc.fill = GridBagConstraints.BOTH;
    ContainerListener listener = new ContainerAdapter() {
      public void componentAdded(ContainerEvent	e) {
	Component comp = e.getChild();
	if (comp instanceof JButton)
	  ((JButton)comp).addActionListener(Calculator.this);
      }
    };
    addContainerListener(listener);
    gbc.gridwidth = 4;
    addGB(this,	theDisplay, 0, 0);
    // make the	top row
    JPanel topRow = new	JPanel(	);
    topRow.addContainerListener(listener);
    gbc.gridwidth = 1;
    gbc.weightx	= 1.0;
    addGB(topRow, new JButton("C"), 0, 0);
    gbc.weightx	= 0.33;
    addGB(topRow, new JButton("%"), 1, 0);
    gbc.weightx	= 1.0;
    addGB(topRow, new JButton("+"), 2, 0 );
    gbc.gridwidth = 4;
    addGB(this,	topRow,	0, 1);
    gbc.weightx	= 1.0;	gbc.gridwidth =	1;
    // make the	digits
    for(int j=0; j<3; j++)
	for(int	i=0; i<3; i++)
	    addGB(this,	new JButton("" + ((2-j)*3+i+1) ), i, j+2);
    // -, x, and divide
    addGB(this,	new JButton("-"), 3, 2);
    addGB(this,	new JButton("x"), 3, 3);
    addGB(this,	new JButton("\u00F7"), 3, 4);
    // make the	bottom row
    JPanel bottomRow = new JPanel();
    bottomRow.addContainerListener(listener);
    gbc.weightx	= 1.0;
    addGB(bottomRow, new JButton("0"), 0, 0);
    gbc.weightx	= 0.33;
    addGB(bottomRow, new JButton("."), 1, 0);
    gbc.weightx	= 1.0;
    addGB(bottomRow, new JButton("="), 2, 0);
    gbc.gridwidth = 4;
    addGB(this,	bottomRow, 0, 5);
  }

  void addGB(Container cont, Component comp, int x, int	y) {
    if ((cont.getLayout() instanceof GridBagLayout) ==	false)
      cont.setLayout(new GridBagLayout(	));
    gbc.gridx =	x; gbc.gridy = y;
    cont.add(comp, gbc);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand().equals("C"))
      theDisplay.setText("");
    else
      theDisplay.setText(theDisplay.getText()
			 + e.getActionCommand());
  }

  public static	void main(String[] args) {
    JFrame frame = new JFrame("Calculator");
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setSize(200, 250);
    frame.setLocation(200, 200);
    frame.setContentPane(new Calculator());
    frame.setVisible(true);
  }
}
