//file: Iguana.java
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

public class Iguana extends JComponent {
  private Image image;
  private int theta;

  public Iguana() {
    image = Toolkit.getDefaultToolkit().getImage(
        "Piazza di Spagna.small.jpg");
    theta = 0;
    addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent me) {
        theta = (theta + 15) % 360;
        repaint();
      }
    });
  }

  public void paint(Graphics g) {
    Graphics2D g2 = (Graphics2D)g;

    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);

    int cx = getSize().width / 2;
    int cy = getSize().height / 2;

    g2.translate(cx, cy);
    g2.rotate(theta * Math.PI / 180);

    Shape oldClip = g2.getClip();
    Shape e = new Ellipse2D.Float(-cx, -cy, cx * 2, cy * 2);
    g2.clip(e);

    Shape c = new Ellipse2D.Float(-cx, -cy, cx * 3 / 4, cy * 2);
    g2.setPaint(new GradientPaint(40, 40, Color.blue,
        60, 50, Color.white, true));
    g2.fill(c);

    g2.setPaint(Color.yellow);
    g2.fillOval(cx / 4, 0, cx, cy);

    g2.setClip(oldClip);

    g2.setFont(new Font("Times New Roman", Font.PLAIN, 64));
    g2.setPaint(new GradientPaint(-cx, 0, Color.red,
        cx, 0, Color.black, false));
    g2.drawString("Hello, 2D!", -cx * 3 / 4, cy / 4);

    AlphaComposite ac = AlphaComposite.getInstance(
        AlphaComposite.SRC_OVER, (float).75);
    g2.setComposite(ac);

    Shape r = new RoundRectangle2D.Float(0, -cy * 3 / 4,
        cx * 3 / 4, cy * 3 / 4, 20, 20);
    g2.setStroke(new BasicStroke(4));
    g2.setPaint(Color.magenta);
    g2.fill(r);
    g2.setPaint(Color.green);
    g2.draw(r);

    g2.drawImage(image, -cx / 2, -cy / 2, this);
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("Iguana");
    Container c = frame.getContentPane();
    c.setLayout(new BorderLayout());
    c.add(new Iguana(), BorderLayout.CENTER);
    frame.setSize(300, 300);
	frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setVisible(true);
  }
}
