//file:	GridBag2.java
import java.awt.*;
import javax.swing.*;

public class GridBag2 extends JPanel {
  GridBagConstraints constraints = new GridBagConstraints();

  public GridBag2() {
    setLayout(new GridBagLayout());
    constraints.weightx	= 1.0;
    constraints.weighty	= 1.0;
    constraints.fill = GridBagConstraints.BOTH;
    int	x, y;  // for clarity
    addGB(new JButton("North"),	 x = 1,	y = 0);
    addGB(new JButton("West"),	 x = 0,	y = 1);
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
    JFrame frame = new JFrame("GridBag2");
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setSize(225, 150);
    frame.setLocation(200, 200);
    frame.setContentPane(new GridBag2());
    frame.setVisible(true);
  }
}
