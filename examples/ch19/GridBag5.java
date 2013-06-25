//file:	GridBag5.java
import java.awt.*;
import javax.swing.*;

public class GridBag5 extends JPanel {
  GridBagConstraints constraints = new GridBagConstraints();

  public GridBag5() {
    setLayout(new GridBagLayout());
    int	x, y;  // for clarity
    addGB(new JButton("North"),	 x = 1,	y = 0);
    constraints.ipadx =	25;  //	add padding
    constraints.ipady =	25;
    addGB(new JButton("West"),	 x = 0,	y = 1);
    constraints.ipadx =	0;   //	remove padding
    constraints.ipady =	0;
    addGB(new JButton("Center"), x = 1,	y = 1);
    addGB(new JButton("East"),	 x = 2,	y = 1);
    addGB(new JButton("South"),	 x = 1,	y = 2);
  }

  void addGB(Component component, int x, int y)	{
    constraints.gridx =	x;
    constraints.gridy =	y;
    add(component, constraints);
  }

  public static	void main(String[] args) {
    JFrame frame = new JFrame("GridBag5");
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    frame.setSize(250, 250);
    frame.setLocation(200, 200);
    frame.setContentPane(new GridBag5());
    frame.setVisible(true);
  }
}
