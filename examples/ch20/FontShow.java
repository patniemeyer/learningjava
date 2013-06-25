//file: FontShow.java
import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import javax.swing.*;

public class FontShow extends JComponent 
{
  private static final int PAD = 25;   // frilly line padding
  private boolean bigFont = true;
  private String message;

  public FontShow(String message) {
    this.message = message;
    addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        bigFont = !bigFont;
        repaint();
      }
    });
  }

  public void paint(Graphics g) 
  {
    Graphics2D g2 = (Graphics2D)g;

    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);

    int size = bigFont ? 96 : 64;
    Font font = new Font("Dialog", Font.PLAIN, size);
    g2.setFont(font);
    int width = getSize().width;
    int height = getSize().height;

    FontRenderContext frc = g2.getFontRenderContext();
    LineMetrics metrics = font.getLineMetrics(message, frc);
    float messageWidth =
        (float)font.getStringBounds(message, frc).getWidth();

    // center text
    float ascent = metrics.getAscent();
    float descent = metrics.getDescent();
    float x = (width - messageWidth) / 2;
    float y = (height + metrics.getHeight()) / 2 - descent;

    g2.setPaint(getBackground());
    g2.fillRect(0, 0, width, height);

    g2.setPaint(getForeground());
    g2.drawString(message, x, y);

    g2.setPaint(Color.white);  // Base lines
    drawLine(g2, x - PAD, y, x + messageWidth + PAD, y);
    drawLine(g2, x, y + PAD, x, y - ascent - PAD);
    g2.setPaint(Color.green);  // Ascent line
    drawLine(g2, x - PAD, y - ascent,
             x + messageWidth + PAD, y - ascent);
    g2.setPaint(Color.red);    // Descent line
    drawLine(g2, x - PAD, y + descent,
             x + messageWidth + PAD, y + descent);
  }

  private void drawLine(Graphics2D g2,
      double x0, double y0, double x1, double y1) {
    Shape line = new java.awt.geom.Line2D.Double(x0, y0, x1, y1);
    g2.draw(line);
  }

  public static void main(String args[]) {
    String message = "Lemming";
    if (args.length > 0) message = args[0];

    JFrame frame = new JFrame("FontShow");
    frame.setSize(420, 300);
	frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.getContentPane().add(new FontShow(message));
    frame.setVisible(true);
  }
}
